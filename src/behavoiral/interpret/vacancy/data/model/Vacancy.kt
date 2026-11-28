package behavoiral.interpret.vacancy.data.model

data class Vacancy(
    val id: Int,
    val title: String,
    val description: String,
    val salary: Double,
    val location: String,
    val company: String,
    val category: String
)