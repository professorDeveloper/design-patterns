package structural.decorator

abstract  class OrderDecorator ( private val order: Order) : Order {
    override fun getDescription(): String {
        return order.getDescription()
    }

    override fun getPrice(): Double {
        return order.getPrice()
    }

}