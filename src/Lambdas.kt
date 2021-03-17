import oop.Car
import oop.Car.Companion.default

//зайдествован класс User

fun main() {
    val lamda = {
        println("Text from lambda")
    }

    lamda()

    val lamdaWithParams = { x: Int -> println("X from lambda^ $x") }
    lamdaWithParams(10)

    val sumLambda = { x: Int, y: Int -> x + y }
    println("Sum x and y = ${sumLambda(30, 2)}")

    val users = listOf(
        User("Vasya", "Sergeev", 30),
        User("Vasya", "Ivanov", 20),
        User("Vasya", "Petrov", 10),
        User("Vasya", "Sidorov", 50)
    )

    //найдем пользователя у которого макс возраст
    //1 способ вручную без библиотечных способов
    var oldestUser: User? = null
    for (user in users) {
        val currentAge = user.age
        val maxAge = oldestUser?.age ?: Int.MIN_VALUE
        if (currentAge > maxAge) {
            oldestUser = user
        }
    }

    //Внутри лямбда выражений можно получить доступ окружающего контекста
    val user1 = users[0]
    val oldestUser3 = users.maxBy { user: User -> user1.age }
    //2.использование встроен фуникций с лямда функций
    val oldestUser2 = users.maxBy { user: User -> user.age }

    //1. вариант пользователь с наибольшей длиной
    val maxNameUser = users.maxBy { it.getFullnameLength() }
    //2. вариант с помощью ссылки на функцию
    val maxNameUser1 = users.maxBy(User::getFullnameLength)
    println("maxNameUser1 $maxNameUser1")

    //функции высшего порядка
    //.default использование объекта по умолчанию, компаньон объект
    val car = Car.default
    car.openDoor1()
    car.closeDoor1 { println("close door custom") }

    //типы функций можно использовать не только в качестве входных параметров, но и в любом месте где требуется тип

    makeCalculations {
        println("result = $it")
    }
    //код который будет вставлен компилятором
    val value = 1 + 1
    println("result = $value")

    makeCalculations1({
        println("result = $it")
    }, {})
}

inline fun makeCalculations(callback: (Int) -> Unit) {
    val value = 1 + 1
    callback(value)
}

inline fun makeCalculations1(callback: (Int) -> Unit, noinline callback2: (Int) -> Unit) {
    val value = 1 + 1
    callback(value)
}