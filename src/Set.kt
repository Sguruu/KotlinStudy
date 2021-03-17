fun main() {
    //Неизменяемое множество
    val immutableSet = setOf(1,2,3,3,2,1,4,5,6,7)
    //по умолчанию используя setOf будет использоваться LinkedHashSet, что означаят сохранение пордяка вставки элементов

    //можно заметить, что исчезли повторяющиеся элементы
    println(immutableSet)

    //для коллекции есть операции, которые позволяют сделать объеденение, вычитание, пересечение ваших коллекций
    //метод union в качестве аргумента принимает другой объект коллекции, и в результате их объединяет
    val unionSet = setOf (1,2,3).union(setOf(1,4,5))
    println(unionSet)

    //метод substract вычетания
    val substractSet = setOf(1,2,3).subtract(setOf(1,2,4))
    println(substractSet)

    //метод intersect пересечения, на выходе дает нам множество элементов содержащихся как в 1 коллекции так и во второй
    val intersectSet = setOf(1,2,4).intersect(setOf(4,5,5))
    println(intersectSet)

    //отсортированное множество по натуральному порятку TreeSet
    val naturalOrderSet = sortedSetOf (1,4,-1,2,5,2)
    //для чисел это порядок по возрастания
    println(naturalOrderSet)

    //для расположения по обыванию, можно использовать функцию .descendingSet()
    println(".descendingSet()  ${naturalOrderSet.descendingSet()}")

    //чтобы сет стал изменяемым, можно использовать функцию .toMutableSet()
    //или
    mutableSetOf(1,2,3).add(34)

    //для создания HashSet, по умолчанию он является mutable по этому можем добавлять в него элементы
    val hashSet = hashSetOf(1,2,3,-4)
    hashSet.add(1)
    hashSet.remove(1)

    //для того, чтобы проверить содержет ли set какой то либо элемент можем воспользовать функцией .contains
    hashSet.contains(1)
    //другой способ записи, вернет tru если 1 содержеться в сете
    1 in hashSet
    println(1 in hashSet)

}