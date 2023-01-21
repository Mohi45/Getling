package videogamedb.Feeders

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
class BasicCustomFeeder extends Simulation{
  val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  var inNumbers=(1 to 10).iterator

  val customFeeder =Iterator.continually(Map("gameId" -> inNumbers.next()))

  def getSpecificGame(): ChainBuilder = {
    repeat(10) {
      feed(customFeeder)
        .exec(http("Get video game with game name : #{gameId}")
          .get("/videogame/#{gameId}")
          .check(status.is(200))).pause(1)
    }
  }

  val scn = scenario("Basic Custom Feeder test")
    .exec(getSpecificGame())

  setUp(scn.inject(atOnceUsers(users = 1)))
    .protocols(httpProtocol)
}
