package creational.abstractfactory.factory

import creational.abstractfactory.product.PaymentProcessor
import creational.abstractfactory.product.RefundProcessor

interface PaymentFactory {
    fun createPaymentProcessor(): PaymentProcessor
    fun createRefundProcessor(): RefundProcessor
}
