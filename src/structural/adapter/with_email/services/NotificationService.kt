package structural.adapter.with_email.services

interface NotificationService {
    fun send(recipient: String, message: String)
}