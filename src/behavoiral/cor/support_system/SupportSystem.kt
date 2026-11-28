package behavoiral.cor.support_system

import behavoiral.cor.support_system.handlers.ChatBot
import behavoiral.cor.support_system.handlers.Manager
import behavoiral.cor.support_system.handlers.Operator
import behavoiral.cor.support_system.handlers.SupportHandler

class SupportSystem {
    private val chain: SupportHandler = ChatBot().apply {
        setNext(Manager()).setNext(Operator())
    }

    fun submit(ticket: Ticket) {
        chain.handleTicket(ticket)
    }
}