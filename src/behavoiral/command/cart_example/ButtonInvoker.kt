package behavoiral.command.cart_example

class ButtonInvoker(
    private val command: Command
) {
    fun click() {
        command.execute()
    }
}