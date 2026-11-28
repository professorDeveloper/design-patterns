package behavoiral.interpret.vacancy.expression

import behavoiral.interpret.vacancy.data.model.Vacancy

class OrExpression(
    private val left: Expression,
    private val right: Expression
) : Expression {
    override fun interpret(vacancy: Vacancy): Boolean {
        return left.interpret(vacancy) || right.interpret(vacancy)
    }
}