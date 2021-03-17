fun main() {
    val strings: String = "string"
    val nullableString: String? = null

    println(strings.length)
    println(nullableString?.length)

    val lenght: Int = strings.length
    val nullabelLenght: Int? = nullableString?.length

    //переворачиваем строку
    nullableString?.reversed()
        //ищем в строке символ 4
        ?.find { it == '4' }
        //превращаем его в число
        ?.isDigit()

    //проверка переменной на null
    if (nullableString != null) {
        //после проверки можно обращатсья к строке без ?
        print("Strings lenght is ${nullableString.length}")
    } else {
        print("String is null")
    }

    //упрощенеи строки выше
    println("Strings lenght is ${nullableString?.length ?: "incorrect"}")
    //?: элвис операнд

    println("Введите число")
    readLine()?.toIntOrNull()
        ?.let { number ->
            println("Вы ввели число $number")
        }
        ?: println("Вы ввели не число")

    printLenght("13rfefref")

}

//Фнукция принимающая null значения в параметрах
fun printLenght (string: String?){
    string ?: return
   // print("Длина строки = ${string.length}")

    //!! оператор позволяющий избежать проверки на null
    //not null assertion (!!)
    //с ними не рекомедуется работать
    print("Длина строки = ${string!!.length}")
}