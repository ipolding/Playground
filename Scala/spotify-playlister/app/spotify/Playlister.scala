package spotify

import com.google.inject.Inject
import play.api.libs.json.{JsString, JsObject}
import play.api.libs.ws.WSClient
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


case class Track(spotifyId: String)
case class Artist(name: String, spotifyId: String)

class Playlister @Inject() (ws: WSClient) {

  def getArtistsTopTracks(artistNames : List[String]) : Future[List[Track]] = {
   val nestedTopTracks : Future[List[List[Track]]] = Future.sequence(artistNames.map(getArtistTopTracks(_)));
   nestedTopTracks.map(_.flatten)
  }

  def getArtistTopTracks(artistName : String) : Future[List[Track]] = {
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
      val jsObject = response.json.asInstanceOf[JsObject]
      val id = jsObject \\ "id"
      val name = jsObject \\ "name"
      Artist(name.head.asInstanceOf[JsString].toString, id.head.asInstanceOf[JsString].toString)
    })
  }

  def getTopTracks(artist : Artist) : Future[List[Track]] = {
    val futureResponse = ws.url(s"https://api.spotify.com/v1/artists/${artist.spotifyId}/top-tracks")
        .withQueryString(
            "country" -> "GB"
        ).get()
    futureResponse.map(response =>  {
      val jsonResponse = response.json.asInstanceOf[JsObject]
      transformToTracks(jsonResponse)
    })
  }

  private def transformToTracks (apiResponse : JsObject ) : List[Track] = {
    val tracksJson = (apiResponse \ "tracks").as[List[JsObject]]
    val trackIds : List[String] = tracksJson.map{json => (json \ "id").as[String]}
    val tracks = trackIds.map(Track(_)).toList
    tracks
  }
}