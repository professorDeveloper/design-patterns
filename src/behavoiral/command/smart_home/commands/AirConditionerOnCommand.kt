package behavoiral.command.smart_home.commands

import behavoiral.command.smart_home.commands.base.Command
import behavoiral.command.smart_home.devices.AirConditioner

class AirConditionerOnCommand(private val airConditioner: AirConditioner) : Command{
    override val name: String = "Air Conditioner On"
    override fun execute() {
        airConditioner.turnOn()
    }
}