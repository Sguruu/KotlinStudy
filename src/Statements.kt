import kotlin.random.Random

fun main() {
    //Выражение
    val a = 5

    val с: Int

    //В Kotline мы так сделать не сможем, т.к. присваивание не является выражением и унего нет возвращаемого значения
    //В Jave мы бы смогли так сделать
    // val b = c = 342

    // также не является возможным, т.к. это инструкция и не возвращает выражения
    /*
    val aa = while (true){
        3
    }
     */

    //Ошибка
   // val aaa = if (true) 4

    //нет ощибки
    val aaa = if (true) 4 else 2

    //Ошибка
//    val aWhen = when {
//        3 == 2 -> "test"
//    }
    val aWhen = when {
        3==2 -> "test"
        else -> "else"
    }

    calculateRandomInt()
           //Возвращает либо null если соответсует предикату либо no null
        .takeIf { it > 4 }
        ?.let { print ("number is greater than 4") }


}

fun calculateRandomInt() = Random.nextInt()