package spotify

import com.google.inject.Inject
import play.api.libs.json.{JsString, JsObject}
import play.api.Logger
import play.api.libs.ws.WSClient
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


case class Track(spotifyId: String)
case class Artist(name: String, spotifyId: String)
case class TopTracksVO(artist: Artist, topTracks : List[Track])

class Playlister @Inject() (ws: WSClient) {

  def getArtistsTopTracks(artistNames : List[String]) : Future[List[TopTracksVO]] = {
                // Future.sequence(artistNames.map(getArtistTopTracks(_).map(_.topTracks)));
   
    val topTrackVOCollection = artistNames.map(getArtistTopTracks(_))
    
   // Futures.sequence
   Future.sequence(topTrackVOCollection.map(_.filter(!_.isEmpty).map(_.get)))
  }

  def getArtistTopTracks(artistName : String) : Future[Option[TopTracksVO]] = {
    val futureArtist = searchForArtist(artistName)
    futureArtist.flatMap(artist => 
         getTopTracks(artist)
      )
  }

  def searchForArtist(artistName : String) : Future[Artist] = {
    val futureResponse = ws.url("https://api.spotify.com/v1/search").withQueryString(
      "type" -> "artist",
      "q" -> artistName,
      "limit" -> "1").get()
    futureResponse.map(response => {
      Logger.info(s"artistResponse=${response.body}")

      val jsObject = response.json.asInstanceOf[JsObject]
      
      val id = jsObject \\ "id"
      val name = jsObject \\ "name"

      val artistName =  name.headOption.getOrElse(JsString("")).asInstanceOf[JsString].value
      val artistId =    id.headOption.getOrElse(JsString("")).asInstanceOf[JsString].value
      
      Artist(artistName, artistId)
    })
  } 

  def getTopTracks(artist : Artist) : Future[Option[TopTracksVO]] = {

    if (artist.name.isEmpty) {
      return Future(None)
    }

    val request = ws.url(s"https://api.spotify.com/v1/artists/${artist.spotifyId}/top-tracks")
        .withQueryString(
            "country" -> "GB"
        )
    val futureResponse = request.get()
      futureResponse.map(response =>  {
      if (response.status != 200) {Logger.error(s"${request.url} gave a ${response.status} with ${response.body}")}
      Logger.info(s"topTracksResponse=${response.body}")

      val jsonResponse = response.json.asInstanceOf[JsObject]
      val topTracks = transformToTracks(jsonResponse)

      Some(TopTracksVO(artist, topTracks))

    })
  }

  private def transformToTracks (apiResponse : JsObject ) : List[Track] = {
    Logger.debug(s"trackResponse=$apiResponse")
    val tracksJson = (apiResponse \ "tracks").as[List[JsObject]]
    val trackIds : List[String] = tracksJson.map{json => (json \ "id").as[String]}
    val tracks = trackIds.map(Track(_)).toList
    tracks
  }
}