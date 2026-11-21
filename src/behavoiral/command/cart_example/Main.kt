package behavoiral.command.cart_example

fun main(args: Array<String>) {
    val cartReceiver = CartReceiver()
    val addToCartCommand = AddToCartCommand(cartReceiver)
    val removeFromCartCommand = RemoveFromCartCommand(cartReceiver)
    val button = ButtonInvoker(addToCartCommand)
    button.click()
}