package creational.abstractfactory.product

import java.math.BigDecimal

interface PaymentProcessor {
    fun pay( decimal: BigDecimal)

}
