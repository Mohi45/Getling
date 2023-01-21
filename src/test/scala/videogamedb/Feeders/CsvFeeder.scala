package videogamedb.Feeders

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

class CsvFeeder extends Simulation{

  val httpProtocol = http.baseUrl("https://www.videogamedb.uk/api")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  val csvFeeder =csv("data/gameCsvFile.csv").circular

  def getSpecificGame(): ChainBuilder = {
    repeat(10){
      feed(csvFeeder)
        .exec(http("Get video game with game name : #{gameName}")
          .get("/videogame/#{gameId}")
          .check(jsonPath("$.name").is("#{gameName}"))
          .check(status.is(200))).pause(1)
    }
  }

  val scn = scenario("Csv Feeder test")
    .exec(getSpecificGame())


  setUp(scn.inject(atOnceUsers(users = 1)))
    .protocols(httpProtocol)
}
