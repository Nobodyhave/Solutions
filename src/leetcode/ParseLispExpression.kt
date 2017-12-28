package leetcode

/**
 * Created by Aleksandr on 15/12/2017.
 * Project Solutions
 *
 * https://leetcode.com/problems/parse-lisp-expression
 */
class ParseLispExpression {
    fun evaluate(expression: String): Int {
        return evaluate(expression.removePrefix("(").removeSuffix(")"), HashMap())
    }

    private fun evaluate(expression: String, variables: MutableMap<String, Int>): Int {
        return when {
            expression.startsWith("(") -> evaluate(expression.removePrefix("(").removeSuffix(")"), variables)
            expression.startsWith("let") -> let(expression, variables)
            expression.startsWith("add") -> add(expression, HashMap(variables))
            expression.startsWith("mult") -> multiply(expression, HashMap(variables))
            else -> evaluateExpression(expression, variables)
        }
    }

    private fun let(expression: String, variables: MutableMap<String, Int>): Int {
        val expr = splitToVariables(expression.removePrefix("let "), variables)
        return evaluateExpression(expr, variables)
    }

    private fun add(expression: String, variables: Map<String, Int>): Int {
        val (expr1, expr2) = splitToExpressions(expression.removePrefix("add "))

        return evaluateExpression(expr1, variables) + evaluateExpression(expr2, variables)
    }

    private fun multiply(expression: String, variables: Map<String, Int>): Int {
        val (expr1, expr2) = splitToExpressions(expression.removePrefix("mult "))

        return evaluateExpression(expr1, variables) * evaluateExpression(expr2, variables)
    }

    private fun splitToVariables(expression: String, variables: MutableMap<String, Int>): String {
        var count = 0
        var expr = ""
        var varsString = ""
        loop@ for ((i, c) in expression.reversed().withIndex()) {
            when (c) {
                ')' -> count++
                '(' -> count--
                ' ' -> {
                    if (count == 0) {
                        expr = expression.substring(expression.length - i)
                        varsString = expression.substring(0, expression.length - i - 1)
                        break@loop
                    }
                }
            }
        }

        count = 0
        var prev = 0
        val tokens = ArrayList<String>()
        for ((i, c) in varsString.withIndex()) {
            when (c) {
                '(' -> count++
                ')' -> count--
                ' ' -> if (count == 0) {
                    tokens.add(varsString.substring(prev, i))
                    prev = i + 1
                }
            }
        }
        tokens.add(varsString.substring(prev, varsString.length))

        tokens
                .withIndex()
                .groupBy { it.index / 2 }
                .map { it.value }
                .forEach {
                    variables[it[0].value] = evaluateExpression(it[1].value, variables)
                }

        return expr
    }

    private fun splitToExpressions(expression: String): Pair<String, String> {
        var count = 0
        for ((i, c) in expression.withIndex()) {
            when (c) {
                '(' -> count++
                ')' -> count--
                ' ' -> if (count == 0) return Pair(expression.substring(0, i), expression.substring(i + 1))
            }
        }

        return Pair("", "")
    }

    private fun evaluateExpression(expression: String, variables: Map<String, Int>): Int {
        return when {
            expression[0].isDigit() || expression[0] == '-' -> expression.toInt()
            expression[0].isLowerCase() -> {
                variables[expression] ?: throw IllegalStateException("Variable wasn't passed")
            }
            else -> evaluate(expression, HashMap(variables))
        }
    }
}