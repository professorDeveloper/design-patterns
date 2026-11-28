package behavoiral.cor.support_system.handlers

import behavoiral.cor.support_system.Ticket
import behavoiral.cor.support_system.TicketLevel

class Operator : SupportHandler() {
    override fun canHandle(ticket: Ticket): Boolean = ticket.level == TicketLevel.HIGH

    override fun processTicket(ticket: Ticket) {
        println("[Operator] #T${ticket.id} solved | Customer: ${ticket.customer}")
    }
}