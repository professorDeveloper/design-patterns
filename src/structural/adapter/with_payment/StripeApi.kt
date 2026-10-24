package structural.adapter.with_payment

class StripeApi {
    fun makeTransaction(amountInCents: Long) {
        println("Stripe orqali to'lov muvaffaqiyatli o'tdi: $amountInCents sent")
    }
}