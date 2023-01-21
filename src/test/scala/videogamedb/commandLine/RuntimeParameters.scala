package videogamedb.commandLine
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
class RuntimeParameters extends Simulation {

    val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
      .acceptHeader("application/json")
      .contentTypeHeader("application/json")

  def userCount: Int = System.getProperty("USERS", "5").toInt
  def rampDuration: Int = System.getProperty("RAMP_DURATION", "10").toInt
  def testDuration: Int = System.getProperty("DURATION", "60").toInt

  before{
    println(s"Running test with ${userCount} users")
    println(s"Ramping user with ${userCount} seconds")
    println(s"Total test duration ${userCount} seconds")
  }

  def gatAllVideoGame(): ChainBuilder = {
    repeat(3) {
      exec(http("Get all video game")
        .get("/videogame").check(status.is(200))).pause(1)
    }
  }

  val scn=scenario("Run Command line")
    .forever{
      exec(gatAllVideoGame())
    }

  setUp(
    scn.inject(
      nothingFor(5),
      rampUsers(userCount).during(rampDuration)
    )
  ).protocols(httpProtocol).maxDuration(testDuration)
}
