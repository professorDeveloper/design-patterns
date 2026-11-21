package behavoiral.cor

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