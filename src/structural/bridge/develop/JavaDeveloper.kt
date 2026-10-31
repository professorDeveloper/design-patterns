package structural.bridge.develop

class JavaDeveloper : Developer {
    override fun runTests() {
        println("Java developer is running tests")
    }

    override fun writeCode() {
        println("Java developer is writing code : .java")
    }
}