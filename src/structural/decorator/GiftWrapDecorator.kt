package structural.decorator

class GiftWrapDecorator (private val order: Order) : OrderDecorator(order) {
    override fun getDescription(): String {
        return super.getDescription() + ", Gift Wrapped"
    }

    override fun getPrice(): Double {
        return super.getPrice() + 5.0
    }
}