package creational.abstractfactory

import creational.abstractfactory.client.CheckoutService
import creational.abstractfactory.factory.ClickFactory
import creational.abstractfactory.factory.PaymeFactory
import java.math.BigDecimal

fun main() {
    val clickProcessor = CheckoutService(ClickFactory())

    clickProcessor.pay(BigDecimal(100))

    val paymeProcessor = CheckoutService(PaymeFactory())
    paymeProcessor.pay(BigDecimal(100))
}
