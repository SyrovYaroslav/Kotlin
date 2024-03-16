package lr3

import java.util.Scanner
import kotlin.random.Random

fun main() {
    val scanner = Scanner(System.`in`)
    val options = arrayOf("камінь", "ножиці", "бумага")

    println("Ведіть: камінь, ножиці чи бумага")

    val playerChoice = scanner.nextLine()

    if (playerChoice !in options) {
        println("Будь ласка, ведіть камінь, ножиці чи бумага")
        main()
    } else {

        val computerChoice = options[Random.nextInt(0, options.size)]

        println("Ваш вибір: $playerChoice")
        println("вибір компьютера: $computerChoice")

        val result = getResult(playerChoice, computerChoice)
        println(result)
    }
}

fun getResult(playerChoice: String, computerChoice: String): String {
    return when {
        playerChoice == computerChoice -> "Ничія!"
        playerChoice == "камінь" && computerChoice == "ножиці" ||
                playerChoice == "ножиці" && computerChoice == "бумага" ||
                playerChoice == "бумага" && computerChoice == "камінь" -> "Ви перемога!"
        else -> "Ви програли!"
    }
}