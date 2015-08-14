import play.api.libs.json._

object GooglePlacesParseTest extends App {

  val zero_results =
    """
      |{
      |  "html_attributions": [],
      |  "results": [],
      |  "status": "ZERO_RESULTS"
      |}
    """.stripMargin

  val json_string =
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



  val googlePlaceJson = Json.parse(zero_results);

  val statusPath = JsPath \ "status"
  googlePlaceJson \ "results"

  val readStatus : Reads[String] = statusPath.read[String]
  val readResultlist : Reads[List[JsObject]] = (__ \ "results").read[List[JsObject]]


  val statusResult = googlePlaceJson.as[String](readStatus)
  val maybeResults = googlePlaceJson.as[List[JsObject]](readResultlist)

  println(statusResult)
  println(maybeResults.headOption)
}
