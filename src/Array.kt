fun main() {
    //функция arrayOf позволяет создать массив
    val array = arrayOf <String> ("Петр","Александр","Василий")

    //user это переменная
    for (user in array){
        println(user)
    }

    //функция, принимает в себя лямбду функцию которая будет вызвана для каждого элемента массива
    array.forEach { println(it) }

    //принимает два аргументы index и значение элемента
    array.forEachIndexed{index, user ->  println("Index = $index, element = $user" )}

    //получить элемент по индексу из массива
    var firstElement = array[0]
    //свойство lastIndex позволяет получить массив по конечному индексу - 1, для того чтобы явно не указывать индекс
    var lastElement = array[array.lastIndex]

    //изменить элемент моссива
    array[0]="Новый Петр"
    array.forEach { println(it) }

    //создать пустой массив в <тип элементов массива>
    val emptyArray = emptyArray<String>()

    //если хотите создать массив большой длины, но незаполнять его в ручную, можно использовать конструктор массивов
    //принимает два аргумента, размер массива, и лямбду функцию
    val largeArray = Array(100){index -> "User #$index"}
    largeArray.forEach { println(it) }

    //также можно складывать массивы
    val arraysum = arrayOf <String> ("Петр","Александр","Василий") + arrayOf("Новый пользователь")
    arraysum.forEach { println(it) }
}