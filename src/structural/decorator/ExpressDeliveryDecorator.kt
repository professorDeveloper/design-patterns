package structural.decorator

class ExpressDeliveryDecorator(private val order: Order) : OrderDecorator(order) {
    override fun getDescription(): String {
        return super.getDescription() + ", Express Delivery"
    }

    override fun getPrice(): Double {
        return super.getPrice() + 10.0
    }
}