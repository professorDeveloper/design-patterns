package behavoiral.command.smart_home.control

import behavoiral.command.smart_home.commands.base.Command

class RemoteControl {
    private val commands = mutableMapOf<String, Command>()

    fun setCommand(button: String, command: Command) {
        commands[button] = command
    }

    fun pressButton(button: String) {
        commands[button]?.execute() ?: println("No command assigned to button: $button")
    }

    fun removeCommand(button: String) {
        commands.remove(button)
    }

    fun clearCommands() {
        commands.clear()
    }

    fun listCommands() {
        println("Commands:")
        commands.forEach { (button, _) ->
            println(button)
        }
    }
}
