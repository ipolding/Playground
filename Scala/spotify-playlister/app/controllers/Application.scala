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

    Logger.debug(s"searched for $artistQuery");

    val playlist = new Playlister(ws)
    val futureTopTracks = playlist.getArtistsTopTracks(artistList.toList)
    futureTopTracks.map{
        topTracks => {
          val artists: List[String] = topTracks.map(_.artist.name)
          val playlist: List[String] = topTracks.flatMap(_.topTracks.map(_.spotifyId))
          val jsonResponse  = Json.obj(
            "artists" -> Json.toJson(artists),
             "playlist" -> Json.toJson(playlist)
            )
          Ok(jsonResponse)
        } 
    }
     .recover({case err : Throwable => Logger.error("Error!", err); BadRequest(JsArray())})
  }
}