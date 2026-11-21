package behavoiral.command.cart_example

class AddToCartCommand(private val receiver: CartReceiver) : Command {
    override fun execute() {
        receiver.addItemToCart()
    }
}