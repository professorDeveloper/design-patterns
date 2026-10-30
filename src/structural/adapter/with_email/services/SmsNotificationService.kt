package structural.adapter.with_email.services

class SmsNotificationService  : NotificationService {
    override fun send(recipient: String, message: String) {
        println("Sending SMS to $recipient: $message")
    }
}