package behavoiral.cor.auth

class LoggingHandler : Handler() {
    override fun handle(request: String) {
        println("Log yozildi: $request")
        super.handle(request)
    }
}