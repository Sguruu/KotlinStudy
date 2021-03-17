//Рекурсивный вызов функции
fun main() {
    print("Введите число: ")
    val n: Int = readLine()?.toIntOrNull() ?: return

    println("Вы ввели число: $n")

    //println(calculateSumRecursive(n))

    println(calculateSumRecursive1(n))
}

//модификатор tailrec позвляет компелировать рекурсивную функцию как цикл
//что позволяет избежать переполнения стека функции
//для правельной работы модификатора необходимо чтобы рекурсивный вызов был послдений
tailrec fun calculateSumRecursive(n: Int): Int {
    return if (n == 0) 0
    else
        n + calculateSumRecursive(n - 1)
}

tailrec fun calculateSumRecursive1(n: Int, accum:Int = 0): Int {
    return if (n == 0) accum
    else
        calculateSumRecursive1(n - 1,accum + n)
}