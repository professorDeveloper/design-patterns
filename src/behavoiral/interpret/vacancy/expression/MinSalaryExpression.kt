package behavoiral.interpret.vacancy.expression

import behavoiral.interpret.vacancy.data.model.Vacancy

class MinSalaryExpression(private val minSalary: Int) : Expression {
    override fun interpret(vacancy: Vacancy): Boolean {
        return vacancy.salary >= minSalary
    }
}