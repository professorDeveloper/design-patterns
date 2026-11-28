package behavoiral.command.smart_home.commands

import behavoiral.command.smart_home.commands.base.Command
import behavoiral.command.smart_home.devices.Light

class LightOffCommand(private val light: Light) : Command {
    override val name: String = "Light Off"
    override fun execute() {
        light.turnOff()
    }
}