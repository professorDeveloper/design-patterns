package structural.composite.with_project

class Team {
    private val developers = mutableListOf<Developer>()
    fun addDeveloper(developer: Developer) {
        developers.add(developer)
    }

    fun removeDeveloper(developer: Developer) {
        developers.remove(developer)
    }

    fun createProject() {
        println("Creating project with ${developers.size} developers")
        developers.forEach { developer ->
            println("----------------------")
            developer.develop()
            developer.test()
            println("----------------------")
        }
    }
}