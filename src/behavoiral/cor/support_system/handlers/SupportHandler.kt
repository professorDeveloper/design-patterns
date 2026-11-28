package behavoiral.cor.support_system.handlers

import behavoiral.cor.support_system.Ticket

abstract class SupportHandler {
    private var next: SupportHandler? = null

    fun setNext(handler: SupportHandler): SupportHandler {
        this.next = handler
        return handler
    }

    protected abstract fun canHandle(ticket: Ticket): Boolean
    protected abstract fun processTicket(ticket: Ticket)

    fun handleTicket(ticket: Ticket) {
        if (canHandle(ticket)) {
            processTicket(ticket)
        } else {
            next?.handleTicket(ticket) ?: println("Ticket #T${ticket.id} cannot be handled")
        }
    }
}