package behavoiral.command.smart_home

import behavoiral.command.smart_home.commands.AirConditionerOffCommand
import behavoiral.command.smart_home.commands.AirConditionerOnCommand
import behavoiral.command.smart_home.commands.LightOffCommand
import behavoiral.command.smart_home.commands.LightOnCommand
import behavoiral.command.smart_home.control.RemoteControl
import behavoiral.command.smart_home.devices.AirConditioner
import behavoiral.command.smart_home.devices.Light

fun main(args: Array<String>) {
    val remoteControl = RemoteControl()

    val light = Light()
    val airConditioner = AirConditioner()

    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)

    val airConditionerOnCommand = AirConditionerOnCommand(airConditioner)
    val airConditionerOffCommand = AirConditionerOffCommand(airConditioner)

    remoteControl.setCommand("Light On", lightOnCommand)
    remoteControl.setCommand("Light Off", lightOffCommand)
    remoteControl.setCommand("Air Conditioner On", airConditionerOnCommand)
    remoteControl.setCommand("Air Conditioner Off", airConditionerOffCommand)

    remoteControl.pressButton("Light On")
    remoteControl.pressButton("Light Off")

    remoteControl.listCommands()

}