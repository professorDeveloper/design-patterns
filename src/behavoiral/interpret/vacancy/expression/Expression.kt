package behavoiral.interpret.vacancy.expression

import behavoiral.interpret.vacancy.data.model.Vacancy

interface Expression {
    fun interpret(vacancy: Vacancy): Boolean
}