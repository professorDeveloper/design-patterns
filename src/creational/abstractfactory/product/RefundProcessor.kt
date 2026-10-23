package creational.abstractfactory.product

import java.math.BigDecimal

interface RefundProcessor {
    fun refund( decimal: BigDecimal)
}
