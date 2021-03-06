import play.api.libs.json._
import play.api.libs.functional.syntax._

object GooglePlacesParseTest extends App {

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

  val statusPath = JsPath \ "status"
  googlePlaceJson \ "results"

  val readStatus: Reads[String] = (__ \ "status").read[String]
  val readResultList: Reads[Seq[JsObject]] = {
    Reads.seq((__ \ "results").read[JsObject])
  }

  val locationPath = (JsPath \ "geometry" \ "location")
  val readResults = (JsPath \ "results")

  val readLocation: Reads[JsObject] = locationPath.read[JsObject]

  val coordinatesReadsBuilder = (JsPath \ "lat").read[Double] and (JsPath \ "lng").read[Double]
  val coordinates: Reads[(Double, Double)] = coordinatesReadsBuilder.apply((lat, lng) => (lat, lng))

  readResults.readNullable(readLocation)

  val readLocations: Reads[Seq[JsObject]] = {
    Reads.seq(readLocation)
  }


  val readOptionalLocations: Reads[Option[Seq[JsObject]]] = {
    (__ \ "results") readNullable (readLocations)
  }

  val readFirstLocation : Reads[Option[JsObject]] = {

    readOptionalLocations map { case maybeLocations =>
      maybeLocations.toList.flatten.headOption
    }

  }

}