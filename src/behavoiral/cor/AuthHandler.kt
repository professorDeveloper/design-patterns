package behavoiral.cor

class AuthHandler : Handler() {
    override fun handle(request: String) {
        if (!request.contains("TOKEN")) {
            println("To'xtatildi: Token yo'q!")
            return
        }
        println("Auth o'tdi")
        super.handle(request)
    }
}