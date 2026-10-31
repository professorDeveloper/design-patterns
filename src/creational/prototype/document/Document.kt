package creational.prototype.document

class Document(
    var id: String,
    var title: String,
    var content: String,
    var author: String,
    var tags: ArrayList<String> = ArrayList()
) : Copyable {


    override fun clone(): Any {
        val list = ArrayList<String>()
        list.addAll(tags)
        return Document(this.id, this.title, this.content, this.author, list)
    }

    override fun toString(): String {
        return "Document(id='$id', title='$title', content='$content', author='$author', tags=$tags)"
    }
}