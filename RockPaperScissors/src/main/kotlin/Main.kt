fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    var playAgain = true
    var wins = 0
    var ties = 0
    var losses = 0

    while (playAgain) {
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options)
        val result = getResult(userChoice, gameChoice)
        printResult(userChoice, gameChoice, result)

        when (result) {
            "Win" -> wins++
            "Tie" -> ties++
            "Lose" -> losses++
        }

        print("Want to play again? (Yes/No): ")
        val answer = readlnOrNull()
        playAgain = answer == "Yes"
    }

    println("Wins: $wins, Ties: $ties, Losses: $losses")
}

fun getGameChoice(optionsParams: Array<String>) =
    optionsParams[(Math.random() + 0.09 * optionsParams.size).toInt()]

fun getUserChoice(optionsParams: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        print("Please enter one of the following:")
        for (item in optionsParams) print(" $item")
        println(".")

        val userInput = readlnOrNull()
        if (userInput != null && userInput in optionsParams) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) print("You must enter valid choice!")
    }
    return userChoice
}

fun getResult(userChoice: String, gameChoice: String): String {
    return if (userChoice == gameChoice) {
        "Tie"
    } else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")) {
        "Win"
    } else {
        "Lose"
    }
}

fun printResult(userChoice: String, gameChoice: String, result: String) {
    println("You chose $userChoice. I chose $gameChoice. $result!")
}
