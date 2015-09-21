
case class Track(artist : String, name : String, url : String)

object SpotifyClientSpec extends FlatSpec with Matchers {

    "The transformToTrack function" 
    should "Take in Spotify track JSON and return a Track case class" 
    in {

    }

    (artistId : String) = {
        val endPoint = s"/v1artists/${artistId}/top-tracks"                     
    }

    def searchForArtists() = ???
    
    def searchForArtist() = ???

    def transformToTrack(track : JsObject) : Track = {
        
    }
    
}

object TestData {

val jsonTrack = Json.parse("""
{
    "album": {
      "album_type": "album",
      "available_markets": [ "AD", "AR", "AT", "AU", "BE", "BG", "BO", "BR", "CA", "CH", "CL", "CO", "CR", "CY", "CZ", "DE", "DK", "DO", "EC", "EE", "ES", "FI", "FR", "GB", "GR", "GT", "HK", "HN", "HU", "IE", "IS", "IT", "LI", "LT", "LU", "LV", "MC", "MT", "MX", "MY", "NI", "NL", "NO", "NZ", "PA", "PE", "PH", "PL", "PT", "PY", "RO", "SE", "SG", "SI", "SK", "SV", "TR", "TW", "US", "UY" ],
      "external_urls": {
        "spotify": "https://open.spotify.com/album/34EYk8vvJHCUlNrpGxepea"
      },
      "href": "https://api.spotify.com/v1/albums/34EYk8vvJHCUlNrpGxepea",
      "id": "34EYk8vvJHCUlNrpGxepea",
      "images": [ {
        "height": 640,
        "url": "https://i.scdn.co/image/6324fe377dcedf110025527873dafc9b7ee0bb34",
        "width": 640
      }, {
        "height": 300,
        "url": "https://i.scdn.co/image/d2e2148023e8a87b7a2f8d2abdfa936154e470b8",
        "width": 300
      }, {
        "height": 64,
        "url": "https://i.scdn.co/image/af45f7b48d8a4c7252e1b1ad9240ed8b08c06b31",
        "width": 64
      } ],
      "name": "Elvis 75 - Good Rockin' Tonight",
      "type": "album",
      "uri": "spotify:album:34EYk8vvJHCUlNrpGxepea"
    },
    "artists": [ {
      "external_urls": {
        "spotify": "https://open.spotify.com/artist/43ZHCT0cAZBISjO8DG9PnE"
      },
      "href": "https://api.spotify.com/v1/artists/43ZHCT0cAZBISjO8DG9PnE",
      "id": "43ZHCT0cAZBISjO8DG9PnE",
      "name": "Elvis Presley",
      "type": "artist",
      "uri": "spotify:artist:43ZHCT0cAZBISjO8DG9PnE"
    } ],
    "available_markets": [ "AD", "AR", "AT", "AU", "BE", "BG", "BO", "BR", "CA", "CH", "CL", "CO", "CR", "CY", "CZ", "DE", "DK", "DO", "EC", "EE", "ES", "FI", "FR", "GB", "GR", "GT", "HK", "HN", "HU", "IE", "IS", "IT", "LI", "LT", "LU", "LV", "MC", "MT", "MX", "MY", "NI", "NL", "NO", "NZ", "PA", "PE", "PH", "PL", "PT", "PY", "RO", "SE", "SG", "SI", "SK", "SV", "TR", "TW", "US", "UY" ],
    "disc_number": 3,
    "duration_ms": 260973,
    "explicit": false,
    "external_ids": {
      "isrc": "USRC16901355"
    },
    "external_urls": {
      "spotify": "https://open.spotify.com/track/6fgjU6IfBOXHI3OKtndEeE"
    },
    "href": "https://api.spotify.com/v1/tracks/6fgjU6IfBOXHI3OKtndEeE",
    "id": "6fgjU6IfBOXHI3OKtndEeE",
    "name": "Suspicious Minds",
    "popularity": 70,
    "preview_url": "https://p.scdn.co/mp3-preview/3742af306537513a4f446d7c8f9cdb1cea6e36d1",
    "track_number": 19,
    "type": "track",
    "uri": "spotify:track:6fgjU6IfBOXHI3OKtndEeE"
  }
""")

}