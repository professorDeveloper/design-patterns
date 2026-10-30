package creational.prototype.document

class DocumentFactory(private var document: Document) {
    fun setDocument(document: Document) {
        this.document = document
    }

    fun cloneDocument(): Document {
        return document.clone() as Document
    }
}