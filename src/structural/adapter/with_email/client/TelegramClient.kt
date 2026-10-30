package structural.adapter.with_email.client

class TelegramClient {
    fun sendTelegramMessage(chatId: String, text: String) {
        println("Sending Telegram message to $chatId: $text")
    }
}