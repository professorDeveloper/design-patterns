package behavoiral.cor.support_system

fun main() {
    val supportSystem = SupportSystem()
    val tickets = listOf(
        Ticket(1, "Low priority issue", TicketLevel.LOW, "Customer A"),
        Ticket(2, "High priority issue", TicketLevel.HIGH, "Customer B"),
        Ticket(3, "Medium priority issue", TicketLevel.MEDIUM, "Customer C")
    )

    tickets.forEach {
        supportSystem.submit(it)
    }
}