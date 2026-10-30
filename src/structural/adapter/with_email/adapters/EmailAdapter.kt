package structural.adapter.with_email.adapters

import structural.adapter.with_email.client.EmailClient
import structural.adapter.with_email.services.NotificationService

class EmailAdapter(
    private val emailClient: EmailClient,
) : NotificationService {
    override fun send(recipient: String, message: String) {
        val subject = "Notification"
        emailClient.sendEmail(recipient, subject, message)
    }

}