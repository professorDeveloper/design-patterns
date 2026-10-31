package structural.bridge.game

fun main(args: Array<String>) {
    val racingGame = GameFactory.createGame("racing")
    val footballGame = GameFactory.createGame("football")
    footballGame.developGame()
    racingGame.developGame()

}