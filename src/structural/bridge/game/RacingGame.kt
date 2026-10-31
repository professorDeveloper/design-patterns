package structural.bridge.game

class RacingGame(override val developer: Developer) : Game {

    override fun developGame() {
        println("-----------")
        println("Developing Racing Game... using ${developer.javaClass.simpleName}")
        developer.writeCode()
        developer.runTests()
        println("-----------")
    }
}