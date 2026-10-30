package structural.adapter.with_email.manager

import structural.adapter.with_email.services.NotificationService

class NotificationManager(private val notificationService: NotificationService) {
    fun sendNotification(recipient: String, message: String) {
        notificationService.send(recipient, message)
    }
}