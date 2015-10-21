package controllers

import com.google.inject.Inject
import play.api._
import play.api.libs.ws.WSClient
import play.api.mvc._
import spotify.Playlister
import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject() (ws: WSClient)  extends Controller {

  def index = Action {

    import scala.concurrent.ExecutionContext.Implicits.global

    val playlist = new Playlister(ws)
    playlist.searchForArtist("radiohead")
      .onComplete(artist => print(artist))
    Ok(views.html.index("Your new application is ready."))
  }

}
