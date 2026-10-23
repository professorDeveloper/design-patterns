package creational.abstractfactory.client

import creational.abstractfactory.factory.PaymentFactory
import creational.abstractfactory.product.PaymentProcessor
import creational.abstractfactory.product.RefundProcessor
import java.math.BigDecimal

class CheckoutService(factory: PaymentFactory) {
    private val refundProcessor: RefundProcessor = factory.createRefundProcessor()
    private val paymentProcessor: PaymentProcessor = factory.createPaymentProcessor()
    fun pay( decimal: BigDecimal) {
        paymentProcessor.pay(decimal)
    }

    fun refund(decimal: BigDecimal) {
        refundProcessor.refund(decimal)
    }
}
