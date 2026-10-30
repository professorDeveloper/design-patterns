package creational.prototype.document

class Document : Copyable {
    var id: String = ""
    var title: String = ""
    var content: String = ""
    var author: String = ""
    var tags: ArrayList<String> = ArrayList()

}