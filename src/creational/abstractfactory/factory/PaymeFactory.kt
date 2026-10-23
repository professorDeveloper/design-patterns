package creational.abstractfactory.factory

import creational.abstractfactory.product.PaymentProcessor
import creational.abstractfactory.product.RefundProcessor
import java.lang.IO.println
import java.math.BigDecimal

class PaymeFactory : PaymentFactory {
    override fun createPaymentProcessor(): PaymentProcessor {
        return PaymePaymentProcessor()
    }

    override fun createRefundProcessor(): RefundProcessor {
        return PaymeRefundProcessor()
    }

    class PaymeRefundProcessor : RefundProcessor {
        override fun refund(decimal: BigDecimal) {
            println("$decimal amount refunded by payme")
        }
    }

    class PaymePaymentProcessor : PaymentProcessor {
        override fun pay(decimal: BigDecimal) {
            println("$decimal amount payed by payme")
        }

    }

}