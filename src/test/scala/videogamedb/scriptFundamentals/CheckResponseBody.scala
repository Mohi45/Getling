package videogamedb.scriptFundamentals

import io.gatling.core.Predef._
import io.gatling.http.Predef._
class CheckResponseBody extends Simulation{

  val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")

  val scn = scenario("Check with json Path")

    .exec(http("Get specific game")
      .get("/videogame/1")
      .check(status.in(200 to 210))
      .check(jsonPath("$.name").is("Resident Evil 4")))
    .pause(1, 10)

    // getting gameId
    .exec(http("Get all video game")
      .get("/videogame").check(jsonPath("$[1].id")
      .saveAs("gameId")))

    .exec{session=> println(session); session}

    //using that gameId
    .exec(http("Get specific game")
      .get("/videogame/#{gameId}").check(jsonPath("$.name")
      .is("Gran Turismo 3")).check(bodyString.saveAs("responseBody")))
    .exec{session=>println(session("responseBody").as[String]); session}
  setUp(scn.inject(atOnceUsers(users = 1))).protocols(httpProtocol)
}
