package structural.composite.file_system

class File(private val name: String, private val size: Int = 5) : FileSystem {

    override fun getSize(): Int {
        return size
    }

    override fun show() {
        println("    File: $name")
    }
}