package lr1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Hello! My name is DICT_Bot.")
    println("Please, remind me your name.")
    print("> ")
    val name = scanner.nextLine()
    println("What a great name you have, $name!")

    guessAge(scanner)
    count(scanner)
    quiz(scanner)

    println("Congratulations, have a nice day!")
}

fun guessAge(scanner: Scanner) {
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")
    print("> ")
    val remainder3 = scanner.nextInt()
    print("> ")
    val remainder5 = scanner.nextInt()
    print("> ")
    val remainder7 = scanner.nextInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    println("Your age is $age!")
}

fun count(scanner: Scanner) {
    println("Now I will prove to you that I can count to any number you want.")
    print("> ")
    val num = scanner.nextInt()
    for (i in 0..num) {
        println("$i!")
    }
}

fun quiz(scanner: Scanner) {
    println("Let's test your programming knowledge.")
    println("Why do we use methods?")
    println("1. To repeat a statement multiple times.")
    println("2. To decompose a program into several small subroutines.")
    println("3. To determine the execution time of a program.")
    println("4. To interrupt the execution of a program.")
    while (true) {
        print("> ")
        val answer = scanner.next()
        if (answer == "2") {
            break
        } else {
            println("Please, try again.")
        }
    }
    println("Completed, have a nice day!")
}
