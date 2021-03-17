fun main() {
    //вызываем конструктор Pair
    val pairl = Pair("key", "value")
    //также можем воспользоваться префиксной функцией
    val pair2 = 1 to 2

    //для получения доступка к элементу, мы можем обращаться как к 1 значению, так и ко второму
    pairl.first
    pairl.second

    println("ferst = ${pairl.first}, second =  ${pairl.second} ")
    println(pair2)

    //создаем Map, который в себя принимает список пар, по умолчанию создается LinkedHashMap
    val map = mapOf(
        "Name1" to "+9999",
        "Name2" to "+8888",
        "Name3" to "+7777"
    )

    //получаем значение по нашему ключу
    println(map["Name1"])
    println(map["Name4"])

    //ключи и значени должны быть одного типа
    //если создать ключи и значения различного вида , то map будет хранит значения типа enu

    val map2 = mapOf(
        1 to "string",
        "str" to 1
    )
    //это делать не рекомендуется, т.к. вы можете не понять какого типа ключи и значения храняться в опред момент

    //по умлочанию функция mapOf mutabelna, чтобы сделать ее не мутабельной нужно toMutableMap /mutablMabOf
    //переводит тип из изменямой в не изменяимою
    val mutableMap = map.toMutableMap()
    //создает неизменяемый map
    val mutableMap2 = mutableMapOf("1" to "2")

    //в не мутабельном map можно добавлять значения по ключю и изменять значения
    mutableMap["Name1"] = "123456"
    mutableMap["Name"] = "123456"
    //функйия принимает в себя ключ и значение
    mutableMap.put("key", "323423423")
    //также можно удалить значение по ключю
    mutableMap.remove("key")

    //также мутабельную колецию можно превратить в не мутабельную спомощью функции toMap
    mutableMap.toMap()

    //ооздание TreeMap. ключи в натуральном порядке,
    val sortedMap = sortedMapOf(
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
    )

    //создание HashMap, не гарантирует орядок для ключей
    val hashMap = hashMapOf(
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
    )

    println(sortedMap)
    println(hashMap)
    //у Map можно получить доступ к ключам и множествам значений, для этого нужно воспользоваться свойствами keys /
    // values
    println(hashMap.keys)
    println(hashMap.values)

    //для итерирования по mapy можно испоьзовать цикл фор
    for (key in hashMap.keys) {

        println("key = $key, value = ${hashMap[key]}")
    }

    //также можно использовать метод forEach
    hashMap.forEach {entry ->  entry.key
        entry.value
    }

    //с помощью диструктивного опредления запись можно преобразовать в след форму
    hashMap.forEach {(key,value)->
        key
        value
    }

}

