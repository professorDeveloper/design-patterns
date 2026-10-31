package structural.bridge.game

object GameFactory {

    fun createGame(type: String, developer: Developer = JavaDeveloper()): Game {
        return when (type) {
            "racing" -> RacingGame(developer)
            "football" -> FootballGame(developer)
            else -> throw IllegalArgumentException("Unknown game type")
        }
    }
}