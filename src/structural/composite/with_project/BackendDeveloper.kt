package structural.composite.with_project

class BackendDeveloper : Developer {
    override val role: String
        get() = "BACKEND"
    override fun develop() {
        println("Backend developer is writing code : .java")
    }

    override fun test() {
        println("Backend developer is running tests")
    }

}