package creational.abstractfactory.factory

import creational.abstractfactory.product.PaymentProcessor
import creational.abstractfactory.product.RefundProcessor
import java.lang.IO.println
import java.math.BigDecimal
import java.sql.Ref

class ClickFactory : PaymentFactory {
    override fun createPaymentProcessor(): PaymentProcessor {
        return ClickPaymentProcessor()
    }

    override fun createRefundProcessor(): RefundProcessor {
        return ClickRefundProcessor()
    }

    private class ClickPaymentProcessor : PaymentProcessor {
        override fun pay(decimal: BigDecimal) {
            println("$decimal amount paid by click")
        }

    }

    private class ClickRefundProcessor : RefundProcessor {
        override fun refund(decimal: BigDecimal) {
            println("$decimal amount refunded by click")
        }

    }
}
