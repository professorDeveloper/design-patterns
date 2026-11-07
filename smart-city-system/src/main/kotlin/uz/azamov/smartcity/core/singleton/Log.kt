package uz.azamov.smartcity.core.singleton

object Log {

    fun info(message: String) {
        println("INFO: $message")
    }

    fun error(message: String) {
        println("ERROR: $message")
    }

}