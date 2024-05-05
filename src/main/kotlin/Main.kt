fun parseExpression(expression: String): Int {
    if (expression.isEmpty()) {
        // empty string
        return 0
    }
    if (expression.length == 1) {
        // digit
        return expression.toInt()
    }
    var bal = 0 // balance of brackets
    var indMul = -1 // index of the last multiplication in the last level of brackets
    var indOther = -1  // index of the last addition or subtraction in the last level of brackets
    var numberOfBrackets = 0 // number of brackets in the last level of brackets
    expression.forEachIndexed { index, char ->
        when (char) {
            '(' -> bal++
            ')' -> bal--
            '*' -> if (bal == 0) indMul = index
            '+', '-' -> if (bal == 0 && index != 0) indOther = index
        }
        if (bal == 0) numberOfBrackets += 1
    }

    if (numberOfBrackets == 1) {
        return parseExpression(expression.substring(1, expression.length - 1))
    }

    return when {
        indOther != -1 -> {
            if (expression[indOther] == '+') {
                parseExpression(expression.substring(0, indOther)) +
                        parseExpression(expression.substring(indOther + 1))
            } else {
                parseExpression(expression.substring(0, indOther)) -
                        parseExpression(expression.substring(indOther + 1))
            }
        }

        indMul != -1 -> parseExpression(expression.substring(0, indMul)) *
                parseExpression(expression.substring(indMul + 1))

        expression[0] == '-' -> -parseExpression(expression.substring(1))
        else -> expression.toInt()
    }
}


fun main() {
    val input = readln()
    println(parseExpression(input))
}