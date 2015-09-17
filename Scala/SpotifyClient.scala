
case class Track(artist : String, name : String, url : String)

object SpotifyClient {

    def getTopTracks(artistId : String) = {
        val endPoint = s"/v1artists/${artistId}/top-tracks"                     
    }

    def searchForArtists() = ???
    
    def searchForArtist() = ???

    def transformToTrack(track : JsObject) : Track = {
        
    }
    
}