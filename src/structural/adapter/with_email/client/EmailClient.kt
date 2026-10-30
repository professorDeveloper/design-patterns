package structural.adapter.with_email.client

class EmailClient {
    fun sendEmail(emailAddress: String, subject: String, body: String) {
        println("Sending email to $emailAddress with subjects: $subject and body: $body")
    }

}