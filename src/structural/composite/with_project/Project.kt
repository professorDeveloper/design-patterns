package structural.composite.with_project


fun main(args: Array<String>) {
    val team = Team()
    val backendDeveloper = BackendDeveloper()
    val frontendDeveloper = FrontendDeveloper()
    team.addDeveloper(backendDeveloper)
    team.addDeveloper(frontendDeveloper)
}