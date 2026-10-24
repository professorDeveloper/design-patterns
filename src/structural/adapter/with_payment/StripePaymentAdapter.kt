package structural.adapter.with_payment

import java.math.BigDecimal

class StripePaymentAdapter(
    private val stripeApi: StripeApi,
    private val exchangeRateToUsd: BigDecimal = 12800.toBigDecimal()
) : PaymentProcessor {


    override fun pay(amountInUzs: BigDecimal) {

        val dollars = amountInUzs / exchangeRateToUsd
        val cents = (dollars * 100.toBigDecimal()).toLong()

        stripeApi.makeTransaction(cents)
    }

}


