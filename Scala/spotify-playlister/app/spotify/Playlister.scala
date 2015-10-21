package spotify

import com.google.inject.Inject
import play.api.libs.json.JsObject
import play.api.libs.ws.WSClient
import scala.concurrent.Future

case class Track(artist: String, name: String, url : String)
case class Artist(name: String, spotifyId: String)

class Playlister @Inject() (ws: WSClient) {

  def generatePlaylist(artistNames :  List[String]) : List[Track] = {
      List()
  }

  def searchForArtists(artistNames : List[String]) : List[Artist] = {
    List()
  }

  def searchForArtist(artistName : String) : Future[Artist] = {
    val futureResponse = ws.url("https://api.spotify.com/search").withQueryString(
      "type" -> "artist",
      "limit" -> "1").get()
    futureResponse.map(response => {
      val jsObject = response.json.asInstanceOf[JsObject]
      print(jsObject)
      Artist("name", "id")
    })
  }

  def getTopTracks(artist : Artist) : List[Track] = {
    List()
  }

  def transformToTrack (apiResponse : JsObject ) : Track = {
    Track("artist", "name", "url")
  }


  //flatten List[List[Track]


}
