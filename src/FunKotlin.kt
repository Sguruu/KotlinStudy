fun main() {
    print("Введите число : ")
    val n: Int = readLine()?.toIntOrNull() ?: return

    println("Вы ввели число:$n")

    println("Сумма с помощью while = ${calculateSumByWhile(n)}")
}

fun multiplyAnd(a: Int = 100, b: Int) = a * b

fun maxInt(a: Int, b: Int): Int {
    return if (a < b) b else a
}

fun calculateSumByWhile(n: Int = 5): Long {
    var sum: Long = 0
    var currentNumber: Int = 0
    while (currentNumber <= n) {
        sum += currentNumber
        currentNumber++
    }
    return sum
}

fun calculateSumByWhileInfinite(n: Int = 5): Long {
    var sum: Long = 0
    var currentNumber: Int = 0
    while (true) {
        if (currentNumber > n) return sum
        sum += currentNumber
        currentNumber++
    }

}

fun calculateSumByWhileInfiniteBreak(n: Int = 5): Long {
    var sum: Long = 0
    var currentNumber: Int = 0
    while (true) {
        if (currentNumber > n) break
        sum += currentNumber
        currentNumber++
    }

    return sum 

}