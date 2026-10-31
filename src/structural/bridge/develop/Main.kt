package structural.bridge.develop

fun main(args: Array<String>) {
    val javaDeveloper = JavaDeveloper()
    val kotlinDeveloper = KotlinDeveloper()

    val javaProgram = Program(javaDeveloper)
    val kotlinProgram = Program(kotlinDeveloper)

    javaProgram.develop()
    println("=====================")
    kotlinProgram.develop()
}