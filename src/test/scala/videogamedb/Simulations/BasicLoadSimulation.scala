package videogamedb.Simulations
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class BasicLoadSimulation extends Simulation {

  val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  def gatAllVideoGame(): ChainBuilder = {
    repeat(3) {
      exec(http("Get all video game")
        .get("/videogame").check(status.is(200)))
    }
  }

  def gatSingleVideoGame(): ChainBuilder = {
      exec(http("Get specific video game")
        .get("/videogame/2").check(status.in(200, 210)))
  }

  val scn = scenario("Basic load simulation test")
    .exec(gatAllVideoGame())
    .pause(5)
    .exec(gatSingleVideoGame())
    .pause(5)
    .exec(gatAllVideoGame())


  setUp(scn.inject(
    nothingFor(5),
    atOnceUsers(5),
    rampUsers(10).during(10)//default during is in second
  ).protocols(httpProtocol)
  )
}
