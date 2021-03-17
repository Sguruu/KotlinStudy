fun main() {
    //неизменяемый список
    val immutableList = listOf("1", "2", "3")
    println(immutableList)

    immutableList[0]

    immutableList.forEach { println(it) }

    //пустой список
    val emptyList = emptyList<String>()

    //если мы захотим изменить элемент неизменяемого списка
    //immutableList[0] = "1"
    //ошибка компеляции
    //но если использовать метод mutableListOf

    val noImmutableList = mutableListOf<String>("1", "2", "3")
    noImmutableList[0] = "1"
    println(noImmutableList)

    //удаление элемента
    noImmutableList.removeAt(0)
    //добавить элемент в начало (в конец списка)
    noImmutableList.add("4")
    //добавить с индексом
    noImmutableList.add(1,"new element")

    println(noImmutableList)

    //также в изменяемый список можно добавить все элементы из другого списка
    noImmutableList.addAll(listOf("10","20"))
    println(noImmutableList)

}