package structural.adapter.with_payment

import java.math.BigDecimal

interface PaymentProcessor {
    fun pay(amountInUzs: BigDecimal)
}