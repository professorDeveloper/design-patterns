package structural.bridge.game

class FootballGame(override val developer: Developer) : Game {
    override fun developGame() {
        println("Developing Football Game...")
        developer.writeCode()
        developer.runTests()
    }
}