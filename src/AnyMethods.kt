import oop.Car
import oop.Vehicle

fun main() {
//сравнение по ссылке и по значению
    val car1 = Car(wheelCount = 4, maxSpeed = 200, doorCount = 4)
    val car2 = Car(wheelCount = 4, maxSpeed = 200, doorCount = 4)
    val car3 = car1

    println("car 1 equals to car2 by reference = ${car1 === car2}")
    println("car1 equals to car3 by reference = ${car1 === car3}")
    println("car1 equals to car3 by value = ${car1 == car2}")
    //выдает false т.к. нужно определить (в классе объекта) как мы будем сравнивать классы с помощью метода equals

    //сравнения объекта класса с его родителем
    car1 == Vehicle(maxSpeed = 100)

    //создаем список
    val cars = listOf(
        car1,
        Car(wheelCount = 2, maxSpeed = 100, doorCount = 2),
        Car(wheelCount = 2, maxSpeed = 100, doorCount = 3)
    )
    //проверим есть ли внутри списка какой0то объект
    //передается в параметрах объект который мы ищем в списке
    //для корректной работые необходимо предопределить метод equals
    println(cars.contains(Car(wheelCount = 2, maxSpeed = 100, doorCount = 2)))

    //работа с хэш кодом
    //создание хэш таблицы
    val map = hashMapOf(
        car1 to "1",
        car2 to "2",
        Car (wheelCount = 2,maxSpeed = 100,doorCount = 2) to "3"
    )

    //получение строки по ключу
    //если не определен хэш код, то мы не получим наше значение в большинстве случаев
    println(map[Car(wheelCount = 4, maxSpeed = 200, doorCount = 4)])

}