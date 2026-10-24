package structural.adapter.with_payment

fun main(args: Array<String>) {
    val stripeApi = StripeApi()

    val paymentProcessor = StripePaymentAdapter(stripeApi, 11910.toBigDecimal())

    paymentProcessor.pay(23100.toBigDecimal())

}