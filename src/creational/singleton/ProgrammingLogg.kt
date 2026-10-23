package creational.singleton

class ProgrammingLogg private constructor() {

    companion object {
        @Volatile
        private var instance: ProgrammingLogg? = null
        fun getInstance(): ProgrammingLogg {
            return instance ?: synchronized(this) {
                instance ?: ProgrammingLogg().also { instance = it }
            }
        }
    }

    fun log(message: String) {
        println(message)
    }

    fun showError(message: String) {
        println("ERR:$message")
    }
}
