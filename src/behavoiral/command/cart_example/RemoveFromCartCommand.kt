package behavoiral.command.cart_example

class RemoveFromCartCommand(private val receiver: CartReceiver) : Command {
    override fun execute() {
        receiver.removeItemFromCart()
    }
}