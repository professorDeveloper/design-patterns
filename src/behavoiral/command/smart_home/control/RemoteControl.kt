package behavoiral.command.smart_home.control

import behavoiral.command.smart_home.commands.base.Command

class RemoteControl {
    private val commands = mutableListOf<Command>()

    fun addCommand(command: Command) {
        commands.add(command)
    }

    fun executeCommands() {
        for (command in commands) {
            command.execute()
        }
        commands.clear()
    }


    fun executeCommand(commandName: String) {
        val command = commands.find { it.name == commandName }
        command?.execute()
    }

    fun clearCommands() {
        commands.clear()
    }

    fun showCommands() {
        if (commands.isEmpty()) {
            println("No commands in the remote control.")
        } else {
            println("Commands in the remote control:")
            for (command in commands) {
                println("- ${command.name}")
            }
        }
    }
}
