package structural.bridge.game

class RacingGame(override val developer: Developer) : Game {

    override fun developGame() {
        println("Developing Racing Game...")
        developer.writeCode()
        developer.runTests()
    }
}