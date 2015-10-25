package controllers

import com.google.inject.Inject
import play.api._
import play.api.libs.ws.WSClient
import play.api.mvc._
import scala.concurrent.Future
import spotify.{Artist, Playlister}

class Application @Inject() (ws: WSClient)  extends Controller {
//Radiohead ID = 4Z8W4fKeB5YxbusRsdQVPb
  def index = Action.async {

    import scala.concurrent.ExecutionContext.Implicits.global

    val playlist = new Playlister(ws)
    val futureTopTracks = playlist.getTopTracks(Artist("Radiohead", "4Z8W4fKeB5YxbusRsdQVPb"))
    futureTopTracks.map{
        topTracks => Ok(views.html.index(topTracks))}
  }

}
