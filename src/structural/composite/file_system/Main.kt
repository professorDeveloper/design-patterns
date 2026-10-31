package structural.composite.file_system

fun main(args: Array<String>) {
    val folder = Folder("Desktop")
    val resume = File("myresume.pdf", 5)
    val picture = File("picture.png", 4)
    folder.add(resume)
    folder.add(picture)
    val projectFolder = Folder("My Projects")
    val projectKt = File("MyProject.kt", 10)
    projectFolder.add(projectKt)
    folder.add(projectFolder)
    folder.show()
    println("FileSystem Size:${folder.getSize()}")
}
