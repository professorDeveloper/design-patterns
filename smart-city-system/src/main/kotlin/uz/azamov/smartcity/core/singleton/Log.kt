package uz.azamov.smartcity.core.singleton

object Log {
    fun info(message: String) = println("INF:$message")
    fun error(message: String) = println("ERR :$message")
}
