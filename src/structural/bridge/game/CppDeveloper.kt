package structural.bridge.game

class CppDeveloper : Developer {
    override fun writeCode() {
        println("Writing C++ code...")
    }

    override fun runTests() {
        println("Running C++ tests...")
    }

}