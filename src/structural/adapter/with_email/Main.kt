package structural.adapter.with_email

import structural.adapter.with_email.adapters.EmailAdapter
import structural.adapter.with_email.adapters.TelegramAdapter
import structural.adapter.with_email.client.EmailClient
import structural.adapter.with_email.client.TelegramClient
import structural.adapter.with_email.manager.NotificationManager
import structural.adapter.with_email.services.SmsNotificationService

fun main(args: Array<String>) {
    val message = "Hello, this is a notification message."
    val recipient = "Azamov"
    val emailClient = EmailClient()
    val telegramClient = TelegramClient()
    val emailAdapter = EmailAdapter(emailClient)
    val telegramAdapter = TelegramAdapter(telegramClient)
    emailAdapter.send(recipient, message)
    telegramAdapter.send(recipient, message)
    val notificationManagerWithEmail = NotificationManager(emailAdapter)
    val notificationManagerWithTelegram = NotificationManager(telegramAdapter)
    val notificationManagerWithSms = NotificationManager(SmsNotificationService())
    notificationManagerWithEmail.sendNotification(recipient, message)
    notificationManagerWithTelegram.sendNotification(recipient, message)
    notificationManagerWithSms.sendNotification(recipient, message)

}