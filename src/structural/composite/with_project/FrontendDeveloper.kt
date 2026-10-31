package structural.composite.with_project

class FrontendDeveloper : Developer {
    override val role: String
        get() = "FRONTEND"

    override fun develop() {
        println("Frontend developer is writing code : .js")
    }

    override fun test() {
        println("Frontend developer is running tests")
    }
}