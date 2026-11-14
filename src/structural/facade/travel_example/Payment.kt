package structural.facade.travel_example

class Payment (private val recipient: Recipient) {
    fun makePayment() {
        println("Payment made for ${recipient.name}")
    }

    fun refundPayment() {
        println("Payment refunded for ${recipient.name}")
    }
}