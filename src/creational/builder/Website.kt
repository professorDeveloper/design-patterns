package creational.builder


class Website {
    private var name: String? = null
    private var cms: Cms? = null
    private var price = 0

    fun setName(name: String?) {
        this.name = name
    }

    fun setCms(cms: Cms?) {
        this.cms = cms
    }

    fun setPrice(price: Int) {
        this.price = price
    }

    override fun toString(): String {
        return "Website{name='$name', cms=$cms, price=$price}"
    }
}