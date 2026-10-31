package structural.bridge.game

class FootballGame(override val developer: Developer) : Game {
    override fun developGame() {
        println("-----------")
        println("Developing Football Game... using ${developer.javaClass.simpleName}")
        developer.writeCode()
        developer.runTests()
    }
}