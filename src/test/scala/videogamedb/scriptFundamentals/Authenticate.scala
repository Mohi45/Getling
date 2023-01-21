package videogamedb.scriptFundamentals
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
class Authenticate extends Simulation{

  val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

//this is methode that generate token
  def authenticate(): ChainBuilder = {
    exec(http("To Find token")
      .post("/authenticate").body(StringBody(
      "{\n  \"password\": \"admin\",\n  \"username\": \"admin\"\n}"
    )).check(jsonPath("$.token").saveAs("jwttoken")))
  }

  //this is methode that create new game
  def createNewGame(): ChainBuilder = {
    exec(http("Create new game")
      .post("/videogame")
      .header("Authorization","Bearer #{jwttoken}")
      .body(StringBody(
      "{\n  \"category\": \"Platform\",\n  \"name\": \"Mario\",\n  \"rating\": \"Mature\",\n  \"releaseDate\": \"2012-05-04\",\n  \"reviewScore\": 85\n}"
    )))
  }


  val scn = scenario("Authentication")
    .exec(authenticate())
    //.exec(createNewGame())


  setUp(scn.inject(atOnceUsers(users = 1)))
    .protocols(httpProtocol)
}
