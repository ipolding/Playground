import play.api.libs.functional.syntax._
import play.api.libs.json._

case class Location(name : String, formattedAddress:String, coordinates: (Double, Double))

object GooglePlacesParseScratchTest extends App {

  val zero_results =
    """
      |{
      |  "html_attributions": [],
      |  "results": [],
      |  "status": "ZERO_RESULTS"
      |}
    """.stripMargin

  val single_result =
    """
    {
      "html_attributions": [],
      "results": [
        {
          "formatted_address": "Smith Square, London SW1P 3HZ, United Kingdom",
          "geometry": {
            "location": {
              "lat": 51.495789,
              "lng": -0.126669
            }
          },
          "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png",
          "id": "86d6b041648e9fce09ef9df1c4dd645d75ee9172",
          "name": "Local Government Association",
          "opening_hours": {
            "open_now": false,
            "weekday_text": []
          },
          "place_id": "ChIJq96I8cIEdkgRsSAFSa7LBgo",
          "reference": "CnRvAAAAGFQhfQ9yz4t9TIyvqt8TYHoNZz1Z3QZN48v0YHrAhHtXN1EWS9MoeRpH_HxniNYfvF5EeVogHGXcE9fQBSAA0FZBjABP__OfvQGGihczPxYXDc72acTxZKIreHv4wfY61dm8FuRdVY8I0011PojMHxIQ5luSHe0QkM7AL521vogIPBoU2f5nrMoV_Ye4ST3rW5iYTiW55wg",
          "types": [
            "point_of_interest",
            "establishment"
          ]
        }
      ],
      "status": "OK"
    }
    """

  val googlePlaceJson = Json.parse(single_result);
  val zeroResultJson = Json.parse(zero_results);

  val readId : Reads[String] = {(__ \ "place_id").read[String]}
  val readName : Reads[String] = {(__ \ "name").read[String]}
  val readFormattedAddress : Reads[String] = {(__ \ "formatted_address").read[String]}
  val readLocation : Reads[JsObject] = {(__ \ "geometry" \ "location").read[JsObject]}
  val readCoordinates : Reads[(Double, Double)] = {
    ((__ \ "lat").read[Double]
      and
    (__ \ "lng").read[Double]).
      apply((_, _))}

  val readResults : Reads[Seq[JsObject]] = {
    (__ \ "results").read[Seq[JsObject]]
  }

  case class GooglePlace(id : String, name : String, formattedAddress : String, coords : (Double, Double))

  val readGooglePlace : Reads[GooglePlace] = {
    (readId and
      readName and
      readFormattedAddress and
      readLocation.andThen(readCoordinates))(GooglePlace.apply _)
  }

  val maybeReadFirstResult : Reads[Option[JsObject]] = {
    readResults.map(_.headOption)
  }

  val readPlace : Reads[Option[GooglePlace]] = {
    maybeReadFirstResult.map(_.map(_.as[GooglePlace](readGooglePlace)))
    }

  println(googlePlaceJson.as[Option[GooglePlace]](readPlace))
  println(zeroResultJson.as[Option[GooglePlace]](readPlace))

}