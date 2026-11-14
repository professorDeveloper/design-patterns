package uz.azamov.smartcity.core.utils
import java.util.Scanner

private val scanner = Scanner(System.`in`)

fun menu(title: String, vararg options: String, exit: String = "Orqaga"): String? {
    println("\n--- $title ---")
    options.forEachIndexed { i, option -> println("${i + 1}. $option") }
    println("0. $exit")
    return ask("Tanlovingiz: ")
}


fun ask(prompt: String): String? {
    print(prompt)
    return if (scanner.hasNextLine()) scanner.nextLine().trim() else null
}

fun askCount(prompt: String): Int? =
    ask(prompt)?.toIntOrNull()?.takeIf { it >= 0 } ?: invalid("Manfiy bo'lmagan butun son kiriting.")

fun askAmount(prompt: String): Double? =
    ask(prompt)?.toDoubleOrNull()?.takeIf { it >= 0 } ?: invalid("Manfiy bo'lmagan son kiriting.")

fun askYesNo(prompt: String): Boolean? = when (ask("$prompt (ha/yo'q): ")?.lowercase()) {
    "ha" -> true
    "yo'q", "yoq" -> false
    else -> invalid("\"ha\" yoki \"yo'q\" deb javob bering.")
}

fun <T> invalid(message: String): T? {
    println(message)
    return null
}