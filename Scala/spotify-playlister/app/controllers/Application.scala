package controllers

import com.google.inject.Inject
import play.api._
import play.api.libs.ws.WSClient
import play.api.mvc._
import spotify.{Artist, Playlister}

class Application @Inject() (ws: WSClient)  extends Controller {
//Radiohead ID = 4Z8W4fKeB5YxbusRsdQVPb
  def index = Action {

    import scala.concurrent.ExecutionContext.Implicits.global

    val playlist = new Playlister(ws)
    playlist
      .searchForArtist("radiohead")
      .onComplete(artist => print(artist))

    playlist
      .getTopTracks(Artist("Radiohead", "4Z8W4fKeB5YxbusRsdQVPb"))
      .onComplete(print(_))

    Ok(views.html.index("Your new application is ready."))
  }

}
