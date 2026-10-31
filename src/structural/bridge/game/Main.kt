package structural.bridge.game

fun main(args: Array<String>) {
    val racingGame = RacingGame(CppDeveloper())
    val footballGame = FootballGame(JavaDeveloper())
    footballGame.developGame()
    racingGame.developGame()

}