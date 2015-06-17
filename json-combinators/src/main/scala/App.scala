import play.api.libs.json._

object Main extends App {

  val json_string =
    """
      {"DailyAirQualityIndex":{"@MonitoringIndexDate":"2015-06-13 00:00:00","@GroupName":"London","@TimeToLive":"9","LocalAuthority":[{"@LocalAuthorityCode":"1","@LocalAuthorityName":"Barking and Dagenham","@LaCentreLatitude":"51.538435","@LaCentreLongitude":"0.11467","@LaCentreLatitudeWGS84":"6717095.01808","@LaCentreLongitudeWGS84":"12765.0060093","Site":{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BG2","@SiteName":"Barking and Dagenham - Scrattons Farm","@SiteType":"Suburban","@Latitude":"51.529389","@Longitude":"0.132857","@LatitudeWGS84":"6715476.18683","@LongitudeWGS84":"14789.5735883","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}},{"@LocalAuthorityCode":"2","@LocalAuthorityName":"Barnet","@LaCentreLatitude":"51.652929","@LaCentreLongitude":"-0.199606","@LaCentreLatitudeWGS84":"6737612.214325","@LaCentreLongitudeWGS84":"-22220.038279"},{"@LocalAuthorityCode":"3","@LocalAuthorityName":"Bexley","@LaCentreLatitude":"51.441355","@LaCentreLongitude":"0.14861","@LaCentreLatitudeWGS84":"6699738.789844","@LaCentreLongitudeWGS84":"16543.189527","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BQ7","@SiteName":"Bexley - Belvedere West","@SiteType":"Urban Background","@Latitude":"51.4946486813055","@Longitude":"0.137279111232178","@LatitudeWGS84":"6709278.28804","@LongitudeWGS84":"14951.9364255","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BQ8","@SiteName":"Bexley - Belvedere West FDMS","@SiteType":"Urban Background","@Latitude":"51.4946486813055","@Longitude":"0.137279111232178","@LatitudeWGS84":"6709278.28804","@LongitudeWGS84":"14951.9364255","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BX0","@SiteName":"Bexley - Belvedere FDMS","@SiteType":"Suburban","@Latitude":"51.4906102082147","@Longitude":"0.158914493927518","@LatitudeWGS84":"6708546.55118","@LongitudeWGS84":"17686.6633362","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BX1","@SiteName":"Bexley - Slade Green","@SiteType":"Suburban","@Latitude":"51.4659832746662","@Longitude":"0.184877126994369","@LatitudeWGS84":"6704140.10457","@LongitudeWGS84":"20577.2727637","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BX2","@SiteName":"Bexley - Belvedere","@SiteType":"Suburban","@Latitude":"51.4906102082147","@Longitude":"0.158914493927518","@LatitudeWGS84":"6708546.55118","@LongitudeWGS84":"17686.6633362","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BX9","@SiteName":"Bexley - Slade Green FDMS","@SiteType":"Suburban","@Latitude":"51.4659832746662","@Longitude":"0.184877126994369","@LatitudeWGS84":"6704140.10457","@LongitudeWGS84":"20577.2727637","Species":{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GB0","@SiteName":"Greenwich and Bexley - Falconwood FDMS","@SiteType":"Roadside","@Latitude":"51.4563","@Longitude":"0.085606","@LatitudeWGS84":"6702408.29265","@LongitudeWGS84":"9529.61632885","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GB6","@SiteName":"Greenwich and Bexley - Falconwood","@SiteType":"Roadside","@Latitude":"51.4563","@Longitude":"0.085606","@LatitudeWGS84":"6702408.29265","@LongitudeWGS84":"9529.61632885","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"4","@LocalAuthorityName":"Brent","@LaCentreLatitude":"51.552255","@LaCentreLongitude":"-0.30262","@LaCentreLatitudeWGS84":"6719568.804179","@LaCentreLongitudeWGS84":"-33687.504304","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BT4","@SiteName":"Brent - Ikea","@SiteType":"Roadside","@Latitude":"51.552476","@Longitude":"-0.258089","@LatitudeWGS84":"6719608.36938","@LongitudeWGS84":"-28730.3360593","Species":[{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BT5","@SiteName":"Brent - Neasden Lane","@SiteType":"Industrial","@Latitude":"51.552656","@Longitude":"-0.248774","@LatitudeWGS84":"6719640.59457","@LongitudeWGS84":"-27693.3950026","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BT6","@SiteName":"Brent - John Keble Primary School","@SiteType":"Roadside","@Latitude":"51.537799","@Longitude":"-0.247793","@LatitudeWGS84":"6716981.19188","@LongitudeWGS84":"-27584.1905821","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"5","@LocalAuthorityName":"Bromley","@LaCentreLatitude":"51.405683","@LaCentreLongitude":"0.01435","@LaCentreLatitudeWGS84":"6693370.521916","@LaCentreLongitudeWGS84":"1597.434693"},{"@LocalAuthorityCode":"6","@LocalAuthorityName":"Camden","@LaCentreLatitude":"51.551706","@LaCentreLongitude":"-0.158825","@LaCentreLatitudeWGS84":"6719470.518604","@LaCentreLongitudeWGS84":"-17680.318125","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BL0","@SiteName":"Camden - Bloomsbury","@SiteType":"Urban Background","@Latitude":"51.522287","@Longitude":"-0.125848","@LatitudeWGS84":"6714205.47041","@LongitudeWGS84":"-14009.3352774","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CD1","@SiteName":"Camden - Swiss Cottage","@SiteType":"Kerbside","@Latitude":"51.544219","@Longitude":"-0.175284","@LatitudeWGS84":"6718130.26521","@LongitudeWGS84":"-19512.5256242","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CD3","@SiteName":"Camden - Shaftesbury Avenue","@SiteType":"Roadside","@Latitude":"51.515532","@Longitude":"-0.127027","@LatitudeWGS84":"6712997.0244","@LongitudeWGS84":"-14140.580957","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CD9","@SiteName":"Camden - Euston Road","@SiteType":"Roadside","@Latitude":"51.5277066194645","@Longitude":"-0.129053205282516","@LatitudeWGS84":"6715175.15109","@LongitudeWGS84":"-14366.1370973","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"IM1","@SiteName":"Camden - Holborn (inmidtown)","@SiteType":"Kerbside","@Latitude":"51.5173675146177","@Longitude":"-0.1201947113171","@LatitudeWGS84":"6713325.37384719","@LongitudeWGS84":"-13380.0140598641","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"7","@LocalAuthorityName":"City of London","@LaCentreLatitude":"51.51333","@LaCentreLongitude":"-0.088947","@LaCentreLatitudeWGS84":"6712603.132989","@LaCentreLongitudeWGS84":"-9901.534748","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CT3","@SiteName":"City of London - Sir John Cass School","@SiteType":"Urban Background","@Latitude":"51.513847178423","@Longitude":"-0.077765681752","@LatitudeWGS84":"6712695.6436","@LongitudeWGS84":"-8656.83609382","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CT4","@SiteName":"City of London - Beech Street","@SiteType":"Roadside","@Latitude":"51.520225273171","@Longitude":"-0.0961060474176381","@LatitudeWGS84":"6713836.61564","@LongitudeWGS84":"-10698.4762607","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CT6","@SiteName":"City of London - Walbrook Wharf","@SiteType":"Roadside","@Latitude":"51.510499","@Longitude":"-0.091634","@LatitudeWGS84":"6712096.7547","@LongitudeWGS84":"-10200.6502194","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CT8","@SiteName":"City of London - Upper Thames Street","@SiteType":"Roadside","@Latitude":"51.5095436853913","@Longitude":"-0.0873571979556188","@LatitudeWGS84":"6711925.88559","@LongitudeWGS84":"-9724.55879355","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"8","@LocalAuthorityName":"Croydon","@LaCentreLatitude":"51.372361","@LaCentreLongitude":"-0.100401","@LaCentreLatitudeWGS84":"6687426.268766","@LaCentreLongitudeWGS84":"-11176.588195","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CR5","@SiteName":"Croydon - Norbury","@SiteType":"Kerbside","@Latitude":"51.411349","@Longitude":"-0.12311","@LatitudeWGS84":"6694381.70052","@LongitudeWGS84":"-13704.5425116","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"CR7","@SiteName":"Croydon - Purley Way A23","@SiteType":"Roadside","@Latitude":"51.3622305655403","@Longitude":"-0.117604507351392","@LatitudeWGS84":"6685619.97595951","@LongitudeWGS84":"-13091.6738733508","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"9","@LocalAuthorityName":"Ealing","@LaCentreLatitude":"51.513351","@LaCentreLongitude":"-0.304214","@LaCentreLatitudeWGS84":"6712606.889356","@LaCentreLongitudeWGS84":"-33864.947572","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EA6","@SiteName":"Ealing - Hanger Lane Gyratory","@SiteType":"Roadside","@Latitude":"51.53085","@Longitude":"-0.292488","@LatitudeWGS84":"6715737.619","@LongitudeWGS84":"-32559.6152231","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EA7","@SiteName":"Ealing - Southall","@SiteType":"Urban Background","@Latitude":"51.508549","@Longitude":"-0.392179","@LatitudeWGS84":"6711747.97835","@LongitudeWGS84":"-43657.1665798","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EA8","@SiteName":"Ealing - Horn Lane","@SiteType":"Industrial","@Latitude":"51.518948","@Longitude":"-0.265617","@LatitudeWGS84":"6713608.11252","@LongitudeWGS84":"-29568.349186","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EI1","@SiteName":"Ealing - Western Avenue","@SiteType":"Roadside","@Latitude":"51.5236078191481","@Longitude":"-0.265502631799754","@LatitudeWGS84":"6714441.78131","@LongitudeWGS84":"-29555.6177762","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EI7","@SiteName":"Ealing - Southall FDMS","@SiteType":"Urban Background","@Latitude":"51.5085164816243","@Longitude":"-0.392208459173292","@LatitudeWGS84":"6711747.97835","@LongitudeWGS84":"-43657.1665798","Species":{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EI8","@SiteName":"Ealing - Horn Lane TEOM","@SiteType":"Industrial","@Latitude":"51.5189160348806","@Longitude":"-0.265652052386222","@LatitudeWGS84":"6713608.11252","@LongitudeWGS84":"-29568.349186","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"10","@LocalAuthorityName":"Enfield","@LaCentreLatitude":"51.652096","@LaCentreLongitude":"-0.081533","@LaCentreLatitudeWGS84":"6737462.75468","@LaCentreLongitudeWGS84":"-9076.212043","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EN5","@SiteName":"Enfield - Bowes Primary School","@SiteType":"Roadside","@Latitude":"51.613865","@Longitude":"-0.125338","@LatitudeWGS84":"6730606.17452","@LongitudeWGS84":"-13952.562337","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"EN7","@SiteName":"Enfield - Prince of Wales School","@SiteType":"Urban Background","@Latitude":"51.66864334727","@Longitude":"-0.02200720557","@LatitudeWGS84":"6740432.24987404","@LongitudeWGS84":"-2449.83091783529","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"11","@LocalAuthorityName":"Greenwich","@LaCentreLatitude":"51.47879","@LaCentreLongitude":"-0.010677","@LaCentreLatitudeWGS84":"6706427.144723","@LaCentreLongitudeWGS84":"-1188.558203","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GN0","@SiteName":"Greenwich - A206 Burrage Grove","@SiteType":"Roadside","@Latitude":"51.490532","@Longitude":"0.074003","@LatitudeWGS84":"6708526.16964","@LongitudeWGS84":"8237.97627717","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GN2","@SiteName":"Greenwich - Millennium Village","@SiteType":"Industrial","@Latitude":"51.492571","@Longitude":"0.017697","@LatitudeWGS84":"6708890.72071","@LongitudeWGS84":"1970.02102857","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GN3","@SiteName":"Greenwich - Plumstead High Street","@SiteType":"Roadside","@Latitude":"51.486957","@Longitude":"0.095111","@LatitudeWGS84":"6707887.0378","@LongitudeWGS84":"10587.7080888","Species":[{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GN4","@SiteName":"Greenwich - Fiveways Sidcup Rd A20","@SiteType":"Roadside","@Latitude":"51.4346627060562","@Longitude":"0.0642224671704697","@LatitudeWGS84":"6702412.5486","@LongitudeWGS84":"4535.53633525","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GR4","@SiteName":"Greenwich - Eltham","@SiteType":"Suburban","@Latitude":"51.45258","@Longitude":"0.070766","@LatitudeWGS84":"6701743.73787","@LongitudeWGS84":"7877.63508548","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GR5","@SiteName":"Greenwich - Trafalgar Road","@SiteType":"Roadside","@Latitude":"51.483479","@Longitude":"-0.000109","@LatitudeWGS84":"6707265.29552","@LongitudeWGS84":"-12.1338244965","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GR7","@SiteName":"Greenwich - Blackheath","@SiteType":"Roadside","@Latitude":"51.472504","@Longitude":"-0.012381","@LatitudeWGS84":"6705303.66805","@LongitudeWGS84":"-1378.24661551","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GR8","@SiteName":"Greenwich - Woolwich Flyover","@SiteType":"Roadside","@Latitude":"51.486884","@Longitude":"0.017901","@LatitudeWGS84":"6707873.98752","@LongitudeWGS84":"1992.73020469","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"GR9","@SiteName":"Greenwich - Westhorne Avenue","@SiteType":"Roadside","@Latitude":"51.456357","@Longitude":"0.040725","@LatitudeWGS84":"6702418.47577","@LongitudeWGS84":"4533.48626256","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"12","@LocalAuthorityName":"Hackney","@LaCentreLatitude":"51.545787","@LaCentreLongitude":"-0.055418","@LaCentreLatitudeWGS84":"6718410.935789","@LaCentreLongitudeWGS84":"-6169.103541","Site":{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HK6","@SiteName":"Hackney - Old Street","@SiteType":"Roadside","@Latitude":"51.526454","@Longitude":"-0.08491","@LatitudeWGS84":"6714951.02162","@LongitudeWGS84":"-9452.13796326","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}},{"@LocalAuthorityCode":"13","@LocalAuthorityName":"Hammersmith and Fulham","@LaCentreLatitude":"51.486674","@LaCentreLongitude":"-0.212088","@LaCentreLatitudeWGS84":"6707836.445728","@LaCentreLongitudeWGS84":"-23609.528163","Site":{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HF4","@SiteName":"Hammersmith and Fulham - Shepherds Bush","@SiteType":"Roadside","@Latitude":"51.5045625671557","@Longitude":"-0.224670007031603","@LatitudeWGS84":"6711035.01276","@LongitudeWGS84":"-25010.1507793","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}},{"@LocalAuthorityCode":"14","@LocalAuthorityName":"Haringey","@LaCentreLatitude":"51.577629","@LaCentreLongitude":"-0.091721","@LaCentreLatitudeWGS84":"6724112.718777","@LaCentreLongitudeWGS84":"-10210.335015","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HG1","@SiteName":"Haringey - Haringey Town Hall","@SiteType":"Roadside","@Latitude":"51.599302","@Longitude":"-0.068218","@LatitudeWGS84":"6727995.87648","@LongitudeWGS84":"-7593.99302294","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HG4","@SiteName":"Haringey  - Priory Park South","@SiteType":"Urban Background","@Latitude":"51.5839769007709","@Longitude":"-0.125400278484885","@LatitudeWGS84":"6725249.88218781","@LongitudeWGS84":"-13959.4951462721","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"15","@LocalAuthorityName":"Harrow","@LaCentreLatitude":"51.578809","@LaCentreLongitude":"-0.33376","@LaCentreLatitudeWGS84":"6724324.092044","@LaCentreLongitudeWGS84":"-37153.993247","Site":{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HR1","@SiteName":"Harrow - Stanmore","@SiteType":"Urban Background","@Latitude":"51.617327","@Longitude":"-0.298775","@LatitudeWGS84":"6731226.83276","@LongitudeWGS84":"-33259.4808618","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}},{"@LocalAuthorityCode":"16","@LocalAuthorityName":"Havering","@LaCentreLatitude":"51.577924","@LaCentreLongitude":"0.212083","@LaCentreLatitudeWGS84":"6724165.561579","@LaCentreLongitudeWGS84":"23608.971566","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HV1","@SiteName":"Havering - Rainham","@SiteType":"Roadside","@Latitude":"51.520787459334","@Longitude":"0.205460705694044","@LatitudeWGS84":"6713943.19288","@LongitudeWGS84":"22876.155358","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HV3","@SiteName":"Havering - Romford","@SiteType":"Roadside","@Latitude":"51.572976","@Longitude":"0.179079","@LatitudeWGS84":"6723279.28089","@LongitudeWGS84":"19934.9830918","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"17","@LocalAuthorityName":"Hillingdon","@LaCentreLatitude":"51.533411","@LaCentreLongitude":"-0.452568","@LaCentreLatitudeWGS84":"6716195.906043","@LaCentreLongitudeWGS84":"-50379.639309","Site":{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"HI0","@SiteName":"Hillingdon - Keats Way","@SiteType":"Suburban","@Latitude":"51.496309","@Longitude":"-0.460826","@LatitudeWGS84":"6709559.07689","@LongitudeWGS84":"-51298.9156643","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}},{"@LocalAuthorityCode":"18","@LocalAuthorityName":"Hounslow","@LaCentreLatitude":"51.467586","@LaCentreLongitude":"-0.361799","@LaCentreLatitudeWGS84":"6704424.797578","@LaCentreLongitudeWGS84":"-40275.28045"},{"@LocalAuthorityCode":"19","@LocalAuthorityName":"Islington","@LaCentreLatitude":"51.534961","@LaCentreLongitude":"-0.103742","@LaCentreLatitudeWGS84":"6716473.288702","@LaCentreLongitudeWGS84":"-11548.506614","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"IS2","@SiteName":"Islington - Holloway Road","@SiteType":"Roadside","@Latitude":"51.555378","@Longitude":"-0.116146","@LatitudeWGS84":"6720127.92666","@LongitudeWGS84":"-12929.3135777","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"IS6","@SiteName":"Islington - Arsenal","@SiteType":"Urban Background","@Latitude":"51.557895","@Longitude":"-0.106989","@LatitudeWGS84":"6720578.5826","@LongitudeWGS84":"-11909.9610005","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"20","@LocalAuthorityName":"Kensington and Chelsea","@LaCentreLatitude":"51.501886","@LaCentreLongitude":"-0.190895","@LaCentreLatitudeWGS84":"6710556.349032","@LaCentreLongitudeWGS84":"-21250.334195","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KC1","@SiteName":"Kensington and Chelsea - North Ken","@SiteType":"Urban Background","@Latitude":"51.5210467476039","@Longitude":"-0.213492139585065","@LatitudeWGS84":"6713983.58013","@LongitudeWGS84":"-23765.836267","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KC2","@SiteName":"Kensington and Chelsea - Cromwell Road","@SiteType":"Roadside","@Latitude":"51.49550391","@Longitude":"-0.178809464","@LatitudeWGS84":"6709415.12178","@LongitudeWGS84":"-19904.9784815","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KC3","@SiteName":"Kensington and Chelsea - Knightsbridge","@SiteType":"Roadside","@Latitude":"51.49913951","@Longitude":"-0.164337605","@LatitudeWGS84":"6710065.20988","@LongitudeWGS84":"-18293.9785068","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KC4","@SiteName":"Kensington and Chelsea - Kings Road","@SiteType":"Roadside","@Latitude":"51.48743685","@Longitude":"-0.168397129","@LatitudeWGS84":"6707972.82158","@LongitudeWGS84":"-18745.8826513","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KC5","@SiteName":"Kensington and Chelsea - Earls Court Rd","@SiteType":"Kerbside","@Latitude":"51.49019756","@Longitude":"-0.190863311","@LatitudeWGS84":"6708466.37696","@LongitudeWGS84":"-21246.8065916","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KC7","@SiteName":"Kensington and Chelsea - North Ken FDMS","@SiteType":"Urban Background","@Latitude":"51.52106551","@Longitude":"-0.21344617","@LatitudeWGS84":"6713986.93682","@LongitudeWGS84":"-23760.7189562","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"21","@LocalAuthorityName":"Kingston","@LaCentreLatitude":"51.412317","@LaCentreLongitude":"-0.300443","@LaCentreLatitudeWGS84":"6694554.466476","@LaCentreLongitudeWGS84":"-33445.161772","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KT3","@SiteName":"Kingston Upon Thames - Sopwith Way","@SiteType":"Roadside","@Latitude":"51.413691","@Longitude":"-0.302269","@LatitudeWGS84":"6694799.70046663","@LongitudeWGS84":"-33648.431162592","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"KT4","@SiteName":"Kingston Upon Thames - Tolworth Broadway","@SiteType":"Roadside","@Latitude":"51.379312","@Longitude":"-0.281259","@LatitudeWGS84":"6688665.88821522","@LongitudeWGS84":"-31309.6086610253","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"22","@LocalAuthorityName":"Lambeth","@LaCentreLatitude":"51.489112","@LaCentreLongitude":"-0.11067","@LaCentreLatitudeWGS84":"6708272.298688","@LaCentreLongitudeWGS84":"-12319.728046","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"LB4","@SiteName":"Lambeth - Brixton Road","@SiteType":"Kerbside","@Latitude":"51.464113541162","@Longitude":"-0.11458102695123","@LatitudeWGS84":"6703810.46654","@LongitudeWGS84":"-12751.5363509","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"4","@AirQualityBand":"Moderate","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"LB5","@SiteName":"Lambeth - Bondway Interchange","@SiteType":"Industrial","@Latitude":"51.4854867739729","@Longitude":"-0.124545234819213","@LatitudeWGS84":"6707629.96897","@LongitudeWGS84":"-13860.2784792","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"LB6","@SiteName":"Lambeth - Streatham Green","@SiteType":"Urban Background","@Latitude":"51.4282131429499","@Longitude":"-0.13186863879576","@LatitudeWGS84":"6697392.0894","@LongitudeWGS84":"-14679.5497223","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"23","@LocalAuthorityName":"Lewisham","@LaCentreLatitude":"51.456879","@LaCentreLongitude":"-0.015964","@LaCentreLatitudeWGS84":"6702511.73226","@LaCentreLongitudeWGS84":"-1777.104351","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"LW1","@SiteName":"Lewisham - Catford","@SiteType":"Urban Background","@Latitude":"51.445468","@Longitude":"-0.020266","@LatitudeWGS84":"6700473.37417","@LongitudeWGS84":"-2256.00080042","Species":[{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"LW2","@SiteName":"Lewisham - New Cross","@SiteType":"Roadside","@Latitude":"51.474954","@Longitude":"-0.039641","@LatitudeWGS84":"6705741.5303","@LongitudeWGS84":"-4412.81593454","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"LW3","@SiteName":"Lewisham - Mercury Way","@SiteType":"Industrial","@Latitude":"51.4811412184719","@Longitude":"-0.0456708566668043","@LatitudeWGS84":"6706847.41027","@LongitudeWGS84":"-5084.05650824","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"LW4","@SiteName":"Lewisham - Loampit Vale","@SiteType":"Roadside","@Latitude":"51.4646910611736","@Longitude":"-0.016068243204","@LatitudeWGS84":"6703907.50224776","@LongitudeWGS84":"-1788.70865141176","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"24","@LocalAuthorityName":"Merton","@LaCentreLatitude":"51.415672","@LaCentreLongitude":"-0.191814","@LaCentreLatitudeWGS84":"6695153.285882","@LaCentreLongitudeWGS84":"-21352.636807","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"ME1","@SiteName":"Merton - Morden Civic Centre","@SiteType":"Roadside","@Latitude":"51.40105","@Longitude":"-0.195929","@LatitudeWGS84":"6692543.79001","@LongitudeWGS84":"-21810.7165116","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"ME2","@SiteName":"Merton - Merton Road","@SiteType":"Roadside","@Latitude":"51.4161384794862","@Longitude":"-0.192230805042824","@LatitudeWGS84":"6695236.54926","@LongitudeWGS84":"-21399.0353321","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"25","@LocalAuthorityName":"Newham","@LaCentreLatitude":"51.525516","@LaCentreLongitude":"0.035216","@LaCentreLatitudeWGS84":"6714783.190603","@LaCentreLongitudeWGS84":"3920.227188"},{"@LocalAuthorityCode":"26","@LocalAuthorityName":"Redbridge","@LaCentreLatitude":"51.58861","@LaCentreLongitude":"0.082398","@LaCentreLatitudeWGS84":"6726079.956218","@LaCentreLongitudeWGS84":"9172.503402","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"RB4","@SiteName":"Redbridge - Gardner Close","@SiteType":"Roadside","@Latitude":"51.57661","@Longitude":"0.030858","@LatitudeWGS84":"6723930.18984","@LongitudeWGS84":"3435.0968469","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"RB7","@SiteName":"Redbridge - Ley Street","@SiteType":"Urban Background","@Latitude":"51.5694843315237","@Longitude":"0.0829074748964946","@LatitudeWGS84":"6722606.75352","@LongitudeWGS84":"9108.2720562","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"27","@LocalAuthorityName":"Richmond","@LaCentreLatitude":"51.461342","@LaCentreLongitude":"-0.303547","@LaCentreLatitudeWGS84":"6703309.100938","@LaCentreLongitudeWGS84":"-33790.697472","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"RI1","@SiteName":"Richmond Upon Thames - Castlenau","@SiteType":"Roadside","@Latitude":"51.480189","@Longitude":"-0.237335","@LatitudeWGS84":"6706677.20458","@LongitudeWGS84":"-26420.0113474","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"RI2","@SiteName":"Richmond Upon Thames - Barnes Wetlands","@SiteType":"Suburban","@Latitude":"51.476168","@Longitude":"-0.230427","@LatitudeWGS84":"6705958.50423","@LongitudeWGS84":"-25651.016305","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"TD0","@SiteName":"Richmond Upon Thames - Ntl Physical  Lab","@SiteType":"Suburban","@Latitude":"51.4243043441456","@Longitude":"-0.345714576446947","@LatitudeWGS84":"6696103.27675","@LongitudeWGS84":"-37808.8858115","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"28","@LocalAuthorityName":"Southwark","@LaCentreLatitude":"51.501725","@LaCentreLongitude":"-0.097993","@LaCentreLatitudeWGS84":"6710527.557503","@LaCentreLongitudeWGS84":"-10908.530861","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"SK6","@SiteName":"Southwark - Elephant and Castle","@SiteType":"Urban Background","@Latitude":"51.4931557048667","@Longitude":"-0.101527038274853","@LatitudeWGS84":"6700704.67529806","@LongitudeWGS84":"-11301.9382025058","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"SK7","@SiteName":"Southwark - Heygate","@SiteType":"Urban Background","@Latitude":"51.4929813788003","@Longitude":"-0.0985378910481832","@LatitudeWGS84":"6708964.09395799","@LongitudeWGS84":"-10969.1878553268","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"29","@LocalAuthorityName":"Sutton","@LaCentreLatitude":"51.360448","@LaCentreLongitude":"-0.191691","@LaCentreLatitudeWGS84":"6685302.179467","@LaCentreLongitudeWGS84":"-21338.94451","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"ST3","@SiteName":"Sutton - Carshalton","@SiteType":"Suburban","@Latitude":"51.365318","@Longitude":"-0.165936","@LatitudeWGS84":"6686170.43427","@LongitudeWGS84":"-18471.9110243","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"ST4","@SiteName":"Sutton - Wallington","@SiteType":"Kerbside","@Latitude":"51.3586596124998","@Longitude":"-0.149723946604927","@LatitudeWGS84":"6684987.88329","@LongitudeWGS84":"-16663.3032574","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"ST5","@SiteName":"Sutton - Beddington Lane north","@SiteType":"Industrial","@Latitude":"51.389286904505","@Longitude":"-0.141661524779893","@LatitudeWGS84":"6690449.76537","@LongitudeWGS84":"-15766.2908005","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"ST6","@SiteName":"Sutton - Worcester Park","@SiteType":"Kerbside","@Latitude":"51.377923","@Longitude":"-0.240414","@LatitudeWGS84":"6688418.16328","@LongitudeWGS84":"-26762.7640596","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"ST8","@SiteName":"Sutton - Beddington Lane","@SiteType":"Industrial","@Latitude":"51.3835652277943","@Longitude":"-0.1364178614733","@LatitudeWGS84":"6689424.4883013","@LongitudeWGS84":"-15185.9668743151","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"30","@LocalAuthorityName":"Tower Hamlets","@LaCentreLatitude":"51.523244","@LaCentreLongitude":"-0.027208","@LaCentreLatitudeWGS84":"6714376.688877","@LaCentreLongitudeWGS84":"-3028.780706","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"TH2","@SiteName":"Tower Hamlets - Mile End Road","@SiteType":"Roadside","@Latitude":"51.5225294860844","@Longitude":"-0.0421550991900347","@LatitudeWGS84":"6714255.02857","@LongitudeWGS84":"-4688.33167425","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"TH4","@SiteName":"Tower Hamlets - Blackwall","@SiteType":"Roadside","@Latitude":"51.5150461674013","@Longitude":"-0.00841849265642741","@LatitudeWGS84":"6712915.63292","@LongitudeWGS84":"-933.636569283","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"TH5","@SiteName":"Tower Hamlets - Victoria Park","@SiteType":"Urban Background","@Latitude":"51.5405194915241","@Longitude":"-0.033307388878","@LatitudeWGS84":"6717468.09487173","@LongitudeWGS84":"-3707.7615695525","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}]},{"@LocalAuthorityCode":"31","@LocalAuthorityName":"Waltham Forest","@LaCentreLatitude":"51.588638","@LaCentreLongitude":"-0.011762","@LaCentreLatitudeWGS84":"6726084.973003","@LaCentreLongitudeWGS84":"-1309.339851"},{"@LocalAuthorityCode":"32","@LocalAuthorityName":"Wandsworth","@LaCentreLatitude":"51.45679","@LaCentreLongitude":"-0.192679","@LaCentreLatitudeWGS84":"6702495.832131","@LaCentreLongitudeWGS84":"-21448.928167","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WA2","@SiteName":"Wandsworth - Wandsworth Town Hall","@SiteType":"Urban Background","@Latitude":"51.456962","@Longitude":"-0.191074","@LatitudeWGS84":"6702526.5605","@LongitudeWGS84":"-21270.2603838","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WA7","@SiteName":"Wandsworth - Putney High Street","@SiteType":"Kerbside","@Latitude":"51.463429","@Longitude":"-0.215871","@LatitudeWGS84":"6703681.99537","@LongitudeWGS84":"-24030.649797","Species":{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WA8","@SiteName":"Wandsworth - Putney High Street Facade","@SiteType":"Roadside","@Latitude":"51.4637206047191","@Longitude":"-0.215890144123119","@LatitudeWGS84":"6703734.09916","@LongitudeWGS84":"-24032.7809111","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WA9","@SiteName":"Wandsworth - Putney","@SiteType":"Urban Background","@Latitude":"51.4650325059122","@Longitude":"-0.215824580947572","@LatitudeWGS84":"6703968.51315","@LongitudeWGS84":"-24025.4824518","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WAB","@SiteName":"Wandsworth - Tooting High Street","@SiteType":"Roadside","@Latitude":"51.429331","@Longitude":"-0.166524","@LatitudeWGS84":"6697591.67537674","@LongitudeWGS84":"-18537.3668848591","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]},{"@LocalAuthorityCode":"33","@LocalAuthorityName":"Westminster","@LaCentreLatitude":"51.509645","@LaCentreLongitude":"-0.158586","@LaCentreLatitudeWGS84":"6711944.006712","@LaCentreLongitudeWGS84":"-17653.712767","Site":[{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"MY1","@SiteName":"Westminster - Marylebone Road","@SiteType":"Kerbside","@Latitude":"51.52254","@Longitude":"-0.15459","@LatitudeWGS84":"6714250.73471","@LongitudeWGS84":"-17208.8800817","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"O3","@SpeciesDescription":"Ozone","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"SO2","@SpeciesDescription":"Sulphur Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"MY7","@SiteName":"Westminster - Marylebone Road FDMS","@SiteType":"Kerbside","@Latitude":"51.52254","@Longitude":"-0.15459","@LatitudeWGS84":"6714250.73471","@LongitudeWGS84":"-17208.8800817","Species":[{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM25","@SpeciesDescription":"PM2.5 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"NB1","@SiteName":"Westminster - Strand (Northbank BID)","@SiteType":"Roadside","@Latitude":"51.511998","@Longitude":"-0.116715","@LatitudeWGS84":"6712364.87549212","@LongitudeWGS84":"-12992.6543679369","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WM0","@SiteName":"Westminster - Horseferry Road","@SiteType":"Urban Background","@Latitude":"51.494681","@Longitude":"-0.131938","@LatitudeWGS84":"6709267.98298","@LongitudeWGS84":"-14687.2709763","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"1","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WM6","@SiteName":"Westminster - Oxford Street","@SiteType":"Kerbside","@Latitude":"51.5139287404213","@Longitude":"-0.152792701881935","@LatitudeWGS84":"6712710.23315","@LongitudeWGS84":"-17008.8057704","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"4","@AirQualityBand":"Moderate","@IndexSource":"Measurement"}},{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"WM8","@SiteName":"Westminster - Victoria","@SiteType":"Urban Background","@Latitude":"51.497066177578","@Longitude":"-0.142438820740121","@LatitudeWGS84":"6709694.46727186","@LongitudeWGS84":"-15856.2169939846","Species":{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"3","@AirQualityBand":"Low","@IndexSource":"Measurement"}}]}]}}
    """


  val site_with_species_array =
    """
      |{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"IS6","@SiteName":"Islington - Arsenal","@SiteType":"Urban Background","@Latitude":"51.557895","@Longitude":"-0.106989","@LatitudeWGS84":"6720578.5826","@LongitudeWGS84":"-11909.9610005","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}
    """.stripMargin

  val airQualityJson = Json.parse(json_string);
  val authoritiesPath : JsPath = JsPath \ "DailyAirQualityIndex" \ "LocalAuthority"
  val readAuthorityName : Reads[String] = (__ \ "@LocalAuthorityName").read[String]
  val authorityJsObjectsReads = authoritiesPath.read[List[JsObject]]
  val readSites : Reads[JsValue] = (JsPath \ "Site").read[JsValue] //could be a JsArray or a JsObject
  val readSpecies : Reads[JsValue] = (__ \ "Species").read[JsValue] //could be a JsArray or a JsObject
  val readSpeciesCode : Reads[String] = (__ \ "@SpeciesCode").read[String]
  val readAirQualityIndex :  Reads[String] = (__ \ "@AirQualityIndex").read[String]

  def readSpeciesAtSite  = (site : JsObject) =>  {site.as[JsValue](readSpecies)}

  def readPollutantFromSpecies(pollutant : String)(species : JsObject) : Option[Int] = {

    print(species)
    if (species.as[String](readSpeciesCode).equals(pollutant)) {
      Option(species.as[String](readAirQualityIndex).toInt)
    } else {
      None
    }
  }

  def collectPollutantLevels(pollutant : String)(species : List[JsValue]): List[JsValue] = {
    species.filter(js => (js.as[String](readSpeciesCode).equals(pollutant)))
  }


  //species is Optional

  val authorityList : List[JsObject] = airQualityJson.as[List[JsObject]](authorityJsObjectsReads)


  authorityList.map(
    authority => {
      val authorityName = authority.as[String](readAuthorityName)

      val sitesJs :Reads[Option[JsValue]] = (JsPath \ "Site").readNullable[JsValue]

      val sitesOption : Option[JsValue] = authority.as[Option[JsValue]](sitesJs)

      val siteList : Option[List[JsValue]] = sitesOption.flatMap(jsValue => Some(JsonConverter.toList(jsValue)))

      print(siteList)

//      val species : List[JsValue] = sites.flatMap(site => JsonConverter.toList(site \ "Species"))
    })


  def readPollutantLevel(species: JsValue) : Int = {
    (species \ "@AirQualityIndex").as[String].toInt
  }


  val siteWithSpeciesArray = (Json.parse(site_with_species_array) \ "Species").as[List[JsObject]]

  println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
  println("The site with a species array has:")
  println(collectPollutantLevels("NO2")(siteWithSpeciesArray))
  println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")

  val species_json =
    """
        {"@SpeciesCode": "NO2",
        "@SpeciesDescription": "Nitrogen Dioxide",
        "@AirQualityIndex": "2",
        "@AirQualityBand": "Low",
        "@IndexSource": "Measurement"}
    """

  val site_json =
    """
      |{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BG2","@SiteName":"Barking and Dagenham - Scrattons Farm","@SiteType":"Suburban","@Latitude":"51.529389","@Longitude":"0.132857","@LatitudeWGS84":"6715476.18683","@LongitudeWGS84":"14789.5735883","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}
    """.stripMargin

val barking_and_dagenham_json =
  """
    |{"@LocalAuthorityCode":"1","@LocalAuthorityName":"Barking and Dagenham","@LaCentreLatitude":"51.538435","@LaCentreLongitude":"0.11467","@LaCentreLatitudeWGS84":"6717095.01808","@LaCentreLongitudeWGS84":"12765.0060093","Site":{"@BulletinDate":"2015-06-13 00:00:00","@SiteCode":"BG2","@SiteName":"Barking and Dagenham - Scrattons Farm","@SiteType":"Suburban","@Latitude":"51.529389","@Longitude":"0.132857","@LatitudeWGS84":"6715476.18683","@LongitudeWGS84":"14789.5735883","Species":[{"@SpeciesCode":"NO2","@SpeciesDescription":"Nitrogen Dioxide","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"},{"@SpeciesCode":"PM10","@SpeciesDescription":"PM10 Particulate","@AirQualityIndex":"2","@AirQualityBand":"Low","@IndexSource":"Measurement"}]}}
  """.stripMargin
val bexley_json =
  """
    |  {
    |        "@LocalAuthorityCode": "3",
    |        "@LocalAuthorityName": "Bexley",
    |        "@LaCentreLatitude": "51.441355",
    |        "@LaCentreLongitude": "0.14861",
    |        "@LaCentreLatitudeWGS84": "6699738.789844",
    |        "@LaCentreLongitudeWGS84": "16543.189527",
    |        "Site": [
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "BQ7",
    |            "@SiteName": "Bexley - Belvedere West",
    |            "@SiteType": "Urban Background",
    |            "@Latitude": "51.4946486813055",
    |            "@Longitude": "0.137279111232178",
    |            "@LatitudeWGS84": "6709278.28804",
    |            "@LongitudeWGS84": "14951.9364255",
    |            "Species": [
    |              {
    |                "@SpeciesCode": "NO2",
    |                "@SpeciesDescription": "Nitrogen Dioxide",
    |                "@AirQualityIndex": "1",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              },
    |              {
    |                "@SpeciesCode": "O3",
    |                "@SpeciesDescription": "Ozone",
    |                "@AirQualityIndex": "3",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              },
    |              {
    |                "@SpeciesCode": "PM10",
    |                "@SpeciesDescription": "PM10 Particulate",
    |                "@AirQualityIndex": "2",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              }
    |            ]
    |          },
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "BQ8",
    |            "@SiteName": "Bexley - Belvedere West FDMS",
    |            "@SiteType": "Urban Background",
    |            "@Latitude": "51.4946486813055",
    |            "@Longitude": "0.137279111232178",
    |            "@LatitudeWGS84": "6709278.28804",
    |            "@LongitudeWGS84": "14951.9364255",
    |            "Species": {
    |              "@SpeciesCode": "PM10",
    |              "@SpeciesDescription": "PM10 Particulate",
    |              "@AirQualityIndex": "1",
    |              "@AirQualityBand": "Low",
    |              "@IndexSource": "Measurement"
    |            }
    |          },
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "BX0",
    |            "@SiteName": "Bexley - Belvedere FDMS",
    |            "@SiteType": "Suburban",
    |            "@Latitude": "51.4906102082147",
    |            "@Longitude": "0.158914493927518",
    |            "@LatitudeWGS84": "6708546.55118",
    |            "@LongitudeWGS84": "17686.6633362",
    |            "Species": {
    |              "@SpeciesCode": "PM10",
    |              "@SpeciesDescription": "PM10 Particulate",
    |              "@AirQualityIndex": "1",
    |              "@AirQualityBand": "Low",
    |              "@IndexSource": "Measurement"
    |            }
    |          },
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "BX1",
    |            "@SiteName": "Bexley - Slade Green",
    |            "@SiteType": "Suburban",
    |            "@Latitude": "51.4659832746662",
    |            "@Longitude": "0.184877126994369",
    |            "@LatitudeWGS84": "6704140.10457",
    |            "@LongitudeWGS84": "20577.2727637",
    |            "Species": [
    |              {
    |                "@SpeciesCode": "NO2",
    |                "@SpeciesDescription": "Nitrogen Dioxide",
    |                "@AirQualityIndex": "1",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              },
    |              {
    |                "@SpeciesCode": "O3",
    |                "@SpeciesDescription": "Ozone",
    |                "@AirQualityIndex": "3",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              },
    |              {
    |                "@SpeciesCode": "PM10",
    |                "@SpeciesDescription": "PM10 Particulate",
    |                "@AirQualityIndex": "2",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              }
    |            ]
    |          },
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "BX2",
    |            "@SiteName": "Bexley - Belvedere",
    |            "@SiteType": "Suburban",
    |            "@Latitude": "51.4906102082147",
    |            "@Longitude": "0.158914493927518",
    |            "@LatitudeWGS84": "6708546.55118",
    |            "@LongitudeWGS84": "17686.6633362",
    |            "Species": [
    |              {
    |                "@SpeciesCode": "NO2",
    |                "@SpeciesDescription": "Nitrogen Dioxide",
    |                "@AirQualityIndex": "1",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              },
    |              {
    |                "@SpeciesCode": "PM10",
    |                "@SpeciesDescription": "PM10 Particulate",
    |                "@AirQualityIndex": "2",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              }
    |            ]
    |          },
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "BX9",
    |            "@SiteName": "Bexley - Slade Green FDMS",
    |            "@SiteType": "Suburban",
    |            "@Latitude": "51.4659832746662",
    |            "@Longitude": "0.184877126994369",
    |            "@LatitudeWGS84": "6704140.10457",
    |            "@LongitudeWGS84": "20577.2727637",
    |            "Species": {
    |              "@SpeciesCode": "PM25",
    |              "@SpeciesDescription": "PM2.5 Particulate",
    |              "@AirQualityIndex": "2",
    |              "@AirQualityBand": "Low",
    |              "@IndexSource": "Measurement"
    |            }
    |          },
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "GB0",
    |            "@SiteName": "Greenwich and Bexley - Falconwood FDMS",
    |            "@SiteType": "Roadside",
    |            "@Latitude": "51.4563",
    |            "@Longitude": "0.085606",
    |            "@LatitudeWGS84": "6702408.29265",
    |            "@LongitudeWGS84": "9529.61632885",
    |            "Species": {
    |              "@SpeciesCode": "PM10",
    |              "@SpeciesDescription": "PM10 Particulate",
    |              "@AirQualityIndex": "2",
    |              "@AirQualityBand": "Low",
    |              "@IndexSource": "Measurement"
    |            }
    |          },
    |          {
    |            "@BulletinDate": "2015-06-16 00:00:00",
    |            "@SiteCode": "GB6",
    |            "@SiteName": "Greenwich and Bexley - Falconwood",
    |            "@SiteType": "Roadside",
    |            "@Latitude": "51.4563",
    |            "@Longitude": "0.085606",
    |            "@LatitudeWGS84": "6702408.29265",
    |            "@LongitudeWGS84": "9529.61632885",
    |            "Species": [
    |              {
    |                "@SpeciesCode": "NO2",
    |                "@SpeciesDescription": "Nitrogen Dioxide",
    |                "@AirQualityIndex": "2",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              },
    |              {
    |                "@SpeciesCode": "O3",
    |                "@SpeciesDescription": "Ozone",
    |                "@AirQualityIndex": "2",
    |                "@AirQualityBand": "Low",
    |                "@IndexSource": "Measurement"
    |              }
    |            ]
    |          }
    |        ]
    |      }
  """.stripMargin


  authorityList.map(
    authority => {
      val authorityName = authority.as[String](readAuthorityName)

      val siteJson : JsValue = authority \ "Site"

      val siteList = JsonConverter.toList(siteJson)

      println(s"$authorityName has sites: $siteList")


  siteList.foreach(singleSite => {
        val speciesList = JsonConverter.toList(singleSite \ "Species")
        println(s"$authorityName has species: $speciesList")}


  )
    })

  def readSpecies(siteList : JsValue): List[JsValue] = {
    JsonConverter.toList(siteList.as[JsValue](readSpecies))
  }

  def collectAndReadPollutantLevel(pollutant : String)(species : List[JsValue]) : List[Int] = {
    collectPollutantLevels(pollutant)(species).map(readPollutantLevel(_))
  }

  def collectAndReadPollutantForSite(pollutant : String)(site: JsValue) : List[Int] = {
    collectAndReadPollutantLevel(pollutant)(readSpecies(site))
  }
  
  def collectAndReadPollutantForAuthority(pollutant : String)(authority : JsValue) : List[Int] = {
    val sites : List[JsValue] = JsonConverter.toList(authority.as[JsValue](readSites))

    sites.flatMap(collectAndReadPollutantForSite(pollutant)(_))
    
  }

//  print(readPollutantLevel(Json.parse(site_json).as[JsObject]))

  /*
  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}
  println("Collect and read pollutant readings from species:")
  print(collectAndReadPollutantLevel("NO2")(JsonConverter.toList(Json.parse(species_json))))
  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}

  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}
  println("Collect and read pollutant readings from sites:")
  print(collectAndReadPollutantForAuthority("NO2")(Json.parse(authority_json).as[JsValue]))
  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}
*/

  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}
  println("Collect and read pollutant readings for barking and dagenham:")
  print(collectAndReadPollutantForAuthority("NO2")(Json.parse(barking_and_dagenham_json).as[JsValue]))
  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}


  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}
  println("Collect and read pollutant readings for Bexley:")
  print(collectAndReadPollutantForAuthority("NO2")(Json.parse(bexley_json).as[JsValue]))
  for (i <- 1 to 10) {println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")}




}


object JsonConverter {


  def toList(jsVal : JsValue) : List[JsValue] = {
    val jsValueList : List[JsValue] = jsVal match {
      case obj: JsObject => List[JsObject](obj.as[JsObject])
      case number: JsNumber => List[JsNumber](number.as[JsNumber])
      case string: JsString => List[JsString](string.as[JsString])
      case boolean: JsBoolean => List[JsBoolean](boolean.as[JsBoolean])
      case array : JsArray => array.as[List[JsValue]]
      case _ => List[JsObject]()
    }
    jsValueList
  }
}