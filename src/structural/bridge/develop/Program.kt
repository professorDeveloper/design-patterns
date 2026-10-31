package structural.bridge.develop

class Program(
    private val developer: Developer
) {
    fun develop() {
        println("Starting development with ${developer.javaClass.simpleName}")
        developer.runTests()
        println("---------------------")
        developer.writeCode()
    }
}