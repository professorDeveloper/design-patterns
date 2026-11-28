package behavoiral.interpret.vacancy.expression

import behavoiral.interpret.vacancy.data.model.Vacancy

class CategoryExpression : Expression {
    private val category: String

    constructor(category: String) {
        this.category = category
    }

    override fun interpret(vacancy: Vacancy): Boolean {
        return vacancy.category.equals(category, ignoreCase = true)
    }
}