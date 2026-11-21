package behavoiral.cor

fun main(args: Array<String>) {
    val auth = AuthHandler()
    auth.setNext(LoggingHandler())
    auth.handle("TOKEN: Buyurtma #1")
}