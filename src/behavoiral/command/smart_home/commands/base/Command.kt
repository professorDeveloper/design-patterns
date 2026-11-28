package behavoiral.command.smart_home.commands.base

interface Command {
    val name: String
    fun execute()
}