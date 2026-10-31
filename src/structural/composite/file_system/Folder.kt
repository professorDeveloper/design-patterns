package structural.composite.file_system

class Folder(override val name: String) : FileSystem {
    private val fileSystem = mutableListOf<FileSystem>()
    override fun getSize(): Int {
        var totalSize = 0
        fileSystem.forEach {
            totalSize += it.getSize()
        }
        return totalSize
    }

    fun add(file: FileSystem) {
        fileSystem.add(file)
    }

    fun remove(file: FileSystem) {
        fileSystem.remove(file)
    }

    override fun show(indent: String) {
        println("${indent}Folder: $name")
        fileSystem.forEach {
            it.show("$indent  ")
        }
    }
}