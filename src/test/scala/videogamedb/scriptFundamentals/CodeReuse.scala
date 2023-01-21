package videogamedb.scriptFundamentals

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class CodeReuse extends Simulation {

  val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")

  def gatAllVideoGame(): ChainBuilder = {
    repeat(3) {
      exec(http("Get all video game")
        .get("/videogame").check(status.is(200)))
    }
  }

  def gatSingleVideoGame(): ChainBuilder = {
    repeat(3, "counter") {
      exec(http("Get specific video game with id: #{counter}") // #{} used for dynamic value
        .get("/videogame/#{counter}").check(status.in(200, 210)))
    }
  }

  val scn = scenario("Code reuse")
    .exec(gatAllVideoGame())
    .pause(5)
    .exec(gatSingleVideoGame())
    .repeat(2){
      gatAllVideoGame()
    }

  setUp(scn.inject(atOnceUsers(users = 1))).protocols(httpProtocol)
}
