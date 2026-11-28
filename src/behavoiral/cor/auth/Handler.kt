package behavoiral.cor.auth

abstract class Handler {
    private var next: Handler? = null

    fun setNext(handler: Handler): Handler {
        this.next = handler
        return handler
    }

    open fun handle(request: String) {
        next?.handle(request)
    }
}