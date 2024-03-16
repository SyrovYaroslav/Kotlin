package lr2


fun main() {
    println(getEvenOrOdd(5))
    println(multiplyByFourOrFive(6))
    println(getNegative(-5))
    println(calculateAge(2024))
    println(findMin(listOf(34, 15, 88, 2)))
    println(findTwoLargest(listOf(1, 5, 87, 45, 8, 8)))
    println(countPositivesAndSumNegatives(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15)))
    println(countVowels("Hello World"))
    println(findMiddle("studdent"))
    println(multiplicationTable(3))
}

fun getEvenOrOdd(num: Int): String {
    return if (num % 2 == 0) "Even" else "Odd"
}

fun multiplyByFourOrFive(num: Int): Int {
    return if (num % 2 == 0) num * 4 else num * 5
}

fun getNegative(num: Int): Int {
    return if (num >= 0) {
        -num
    } else {
        num
    }
}

fun calculateAge(year: Int): Int {
    return year / 100
}

fun findMin(numbers: List<Int>): Int {
    return numbers.minOrNull() ?: 0
}

fun findTwoLargest(numbers: List<Int>): List<Int> {
    val sortedNumbers = numbers.sorted()
    return sortedNumbers.subList(sortedNumbers.size - 2, sortedNumbers.size)
}

fun countPositivesAndSumNegatives(numbers: List<Int>): List<Int> {
    val positiveCount = numbers.count {
        if (it > 0) {
            true
        } else {
            false
        }
    }
    val negativeSum = numbers.filter {
        if (it < 0) {
            true
        } else {
            false
        }
    }.sum()
    return listOf(positiveCount, negativeSum)
}

fun countVowels(str: String): Int {
    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')
    return str.count {
        if (it.toLowerCase() in vowels) {
            true
        } else {
            false
        }
    }
}

fun findMiddle(str: String): String {
    val middleIndex = str.length / 2
    return if (str.length % 2 == 0) {
        str.substring(middleIndex - 1, middleIndex + 1)
    } else {
        str[middleIndex].toString()
    }
}

fun multiplicationTable(n: Int): List<List<Int>> {
    return List(n) { i ->
        List(n) { j -> (i + 1) * (j + 1) }
    }
}