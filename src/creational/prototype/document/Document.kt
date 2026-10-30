package creational.prototype.document

class Document(
    var id: String,
    var title: String,
    var content: String,
    var author: String,
    var tags: ArrayList<String> = ArrayList()
) : Copyable {


    override fun clone(): Any {
        val newTags = ArrayList<String>()
        newTags.addAll(tags)
        return Document(this.id, this.title, this.content, this.author, newTags)
    }
}