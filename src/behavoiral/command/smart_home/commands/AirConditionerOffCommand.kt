package behavoiral.command.smart_home.commands

import behavoiral.command.smart_home.commands.base.Command
import behavoiral.command.smart_home.devices.AirConditioner

class AirConditionerOffCommand(private val airConditioner: AirConditioner) : Command {
    override val name: String = "Air Conditioner Off"
    override fun execute() {
        airConditioner.turnOff()
    }
}