package structural.composite.with_project

import creational.prototype.Project

fun main(args: Array<String>) {
    val team = Team()
    val backendDeveloper = BackendDeveloper()
    val frontendDeveloper = FrontendDeveloper()
    team.addDeveloper(backendDeveloper)
    team.addDeveloper(frontendDeveloper)

}