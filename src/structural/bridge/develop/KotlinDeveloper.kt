package structural.bridge.develop

class KotlinDeveloper : Developer {
    override fun runTests() {
        println("Kotlin developer is running tests")
    }

    override fun writeCode() {
        println("Kotlin developer is writing code : .kotlin")
    }
}