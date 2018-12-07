package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    fun getCountRightAndWrong(guess: String, secret: String): Pair<Int, Int> {
        var secretCharArray: CharArray = secret.toCharArray()
        var guessCharArray: CharArray = guess.toCharArray()
        var rightPosition = 0
        var wrongPosition = 0

        for (i in secretCharArray.indices) {
            if (secretCharArray[i] == guessCharArray[i]) {
                rightPosition++
                secretCharArray[i] = ' '
                guessCharArray[i] = ' '
            }
        }

        for (i in secretCharArray.indices) {
            for (j in guessCharArray.indices) {
                if (guessCharArray[j] != ' ' && secretCharArray[i] == guessCharArray[j]) {
                    if (i == j) {
                        rightPosition++
                    } else {
                        wrongPosition++
                    }
                    secretCharArray[i] = ' '
                    guessCharArray[j] = ' '
                }
            }
        }

        return Pair(rightPosition, wrongPosition)
    }

    return Evaluation(getCountRightAndWrong(guess, secret).first, getCountRightAndWrong(guess, secret).second)
}
