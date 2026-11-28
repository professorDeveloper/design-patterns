package behavoiral.cor.support_system

data class Ticket(
    val id: Int,
    val message: String,
    val level: TicketLevel,
    val customer: String,
)