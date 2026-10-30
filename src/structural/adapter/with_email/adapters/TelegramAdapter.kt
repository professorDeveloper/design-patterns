package structural.adapter.with_email.adapters

import structural.adapter.with_email.client.TelegramClient
import structural.adapter.with_email.services.NotificationService

class TelegramAdapter(
    val telegramClient: TelegramClient
) : NotificationService {
    override fun send(recipient: String, message: String) {
        println("Finding Telegram user with recipient: $recipient")
        telegramClient.sendTelegramMessage(recipient, message)
    }
}