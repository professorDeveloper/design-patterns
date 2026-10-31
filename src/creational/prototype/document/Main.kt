package creational.prototype.document


fun main(args: Array<String>) {
    val document = Document(
        "My Document",
        "This is the content of my document.",
        "Something else",
        author = "Azamov",
        tags = arrayListOf("#doc", "#lifestyle")
    )
    val documentFactory = DocumentFactory(document)
    val document2 = documentFactory.cloneDocument()
    document2.tags.add("#newTag")
    println(document2)
    println(document)

}