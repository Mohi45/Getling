package videogamedb.scriptFundamentals

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.recorder.internal.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.milliseconds

class CheckResponseCode extends Simulation{

  val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")

  val scn = scenario("Video game DB -3 calls")

    //Ist call
    .exec(http("Get all games - 1st call")
      .get("/videogame").check(status.is(200))).pause(duration = 5)

    //2nd Call
    .exec(http("Get specific game")
      .get("/videogame/1").check(status.in(200 to 210)))
    .pause(1,10)

    //3rd Call

    .exec(http("Get specific game")
      .get("/videogame/2").check(status.not(404),status.not(500)))
    .pause(3000, milliseconds)

  setUp(scn.inject(atOnceUsers(users = 1))).protocols(httpProtocol)
}
