package videogamedb

import io.gatling.core.Predef._
import io.gatling.http.Predef._
class MyFirstTest extends Simulation{
  // 1. Http configuration

  val httpProtocol =http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")


  //2. scenario definition

  val scn = scenario("My First Test")
    .exec(http("Get all games")
      .get("/videogame"))

  // Load Scenario

  setUp(scn.inject(atOnceUsers(users = 1))).protocols(httpProtocol)

}
