package structural.decorator

fun main(args: Array<String>) {
    val basicOrder: Order = BasicOrder()
    println("Basic Order: ${basicOrder.getDescription()}, Price: ${basicOrder.getPrice()}")

    val giftWrappedOrder: Order = GiftWrapDecorator(basicOrder)
    println("Gift Wrapped Order: ${giftWrappedOrder.getDescription()}, Price: ${giftWrappedOrder.getPrice()}")

    val expressDeliveryOrder: Order = ExpressDeliveryDecorator(giftWrappedOrder)
    println("Express Delivery Order: ${expressDeliveryOrder.getDescription()}, Price: ${expressDeliveryOrder.getPrice()}")
}