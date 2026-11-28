package behavoiral.interpret.vacancy

import behavoiral.interpret.vacancy.data.storage.LocalDatabase
import behavoiral.interpret.vacancy.expression.AndExpression
import behavoiral.interpret.vacancy.expression.CategoryExpression
import behavoiral.interpret.vacancy.expression.LocationExpression
import behavoiral.interpret.vacancy.expression.MinSalaryExpression

fun main(args: Array<String>) {
    val category = CategoryExpression("IT")
    val minSalary = MinSalaryExpression(1000)
    val location = LocationExpression("Remote")
    val bestTrio = AndExpression(AndExpression(category, minSalary), location)
    val result = LocalDatabase.vacancies.filter { bestTrio.interpret(it) }
    println("=============================")
    result.forEach {
        println("Vacancy:${it.title} | ${it.company} | Salary:${it.salary} | ${it.location}")
    }
    println("=============================")
}