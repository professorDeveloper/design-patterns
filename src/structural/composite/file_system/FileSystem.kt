package structural.composite.file_system

interface FileSystem {
     val name: String
    fun getSize(): Int
    fun show(indent: String = "")
}