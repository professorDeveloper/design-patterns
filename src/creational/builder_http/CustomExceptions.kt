package creational.builder_http


sealed class NiceHttpError(
    message: String,
    val code: Int = -1,
    val resBody: String = "",
    cause: Throwable? = null
) : Exception(message, cause) {

    class ServerError(
        code: Int,
        resBody: String,
        message: String = "Serv: $code"
    ) : NiceHttpError(message, code, resBody)

    class Timeout(
        message: String = "Timeout ",
        cause: Throwable? = null
    ) : NiceHttpError(message, cause = cause)

    class Network(
        message: String = "No internet connection. Please check your internet connection and try again.",
        cause: Throwable? = null
    ) : NiceHttpError(message, cause = cause)

    class InvalidUrl(
        url: String
    ) : NiceHttpError("Invalid url")

    class Unknown(
        message: String = "Something went wrong. Please try again.",
        cause: Throwable? = null
    ) : NiceHttpError(message, cause = cause)
}