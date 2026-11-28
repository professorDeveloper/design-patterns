package behavoiral.interpret.vacancy.expression

import behavoiral.interpret.vacancy.data.model.Vacancy

class LocationExpression(private val location: String) : Expression {
    override fun interpret(vacancy: Vacancy): Boolean {
        return vacancy.location.equals(location, ignoreCase = true)
    }
}