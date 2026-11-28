package behavoiral.cor.support_system.handlers

import behavoiral.cor.support_system.Ticket
import behavoiral.cor.support_system.TicketLevel

class ChatBot : SupportHandler() {
    override fun canHandle(ticket: Ticket): Boolean = ticket.level == TicketLevel.LOW

    override fun processTicket(ticket: Ticket) {
        println("[BOT] #T${ticket.id} solved | Customer: ${ticket.customer}")
    }
}