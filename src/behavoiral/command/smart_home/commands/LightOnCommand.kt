package behavoiral.command.smart_home.commands

import behavoiral.command.smart_home.commands.base.Command
import behavoiral.command.smart_home.devices.Light

class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}