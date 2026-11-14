package structural.decorator

class BasicOrder : Order {
    override fun getDescription(): String {
        return "Basic order description"
    }

    override fun getPrice(): Double {
        return 10.0
    }

}