package behavoiral.cor.support_system.handlers

import behavoiral.cor.support_system.Ticket
import behavoiral.cor.support_system.TicketLevel

class Manager : SupportHandler() {
    override fun canHandle(ticket: Ticket): Boolean = ticket.level == TicketLevel.MEDIUM

    override fun processTicket(ticket: Ticket) {
        println("[Manager] #T${ticket.id} solved | Customer: ${ticket.customer}")
    }
}