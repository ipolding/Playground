package controllers

import com.google.inject.Inject
import play.api.libs.json.{JsArray, Json}
import play.api.libs.ws.WSClient
import play.api.mvc._
import play.api.Logger
import scala.concurrent.Future
import spotify.{Artist, Playlister}

class Application @Inject() (ws: WSClient)  extends Controller {
//Radiohead ID = 4Z8W4fKeB5YxbusRsdQVPb
  def playlist(artistQuery : String) = Action.async {

    import scala.concurrent.ExecutionContext.Implicits.global

    val artistList = artistQuery.split(",");

    Logger.info(s"searched for $artistQuery");

    val playlist = new Playlister(ws)
    val futureTopTracks = playlist.getArtistsTopTracks(artistList.toList)
    futureTopTracks.map{
        topTracks => {
          val ids: List[String] = topTracks.map(_.spotifyId)
          val jsonResponse  = Json.obj("playlist" -> Json.toJson(ids))
          Ok(jsonResponse)
        } 
    }
     .recover({case err : Throwable => Logger.error("Error!", err); BadRequest(JsArray())})
  }
}