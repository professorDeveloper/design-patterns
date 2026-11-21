package behavoiral.cor

class LoggingHandler : Handler() {
    override fun handle(request: String) {
        println("Log yozildi: $request")
        super.handle(request)
    }
}