import oop.Car

fun main() {
    val user1 = User(name = "name1", lastName = "lastname1")
    val user2 = User(name = "name2", lastName = "lastname2")
    val user1user = User(name = "name1", lastName = "lastname1")

    //сравним пользователей
    println(user1 == user2)
    println(user1 == user1user)

    //equals and hashCode объявляются только для полей, которые мы устанавливали через конструкторы
    user1.innerState = "state1"
    user1user.innerState = "state2"
    println(user1 == user1user)

    //метод .copy создает копию вашего объекта
    val user3 = user1.copy(lastName = "copiedLastName")
    //свойства которые не определены в основном конструкторе не копируются
    println("user3 inner state = ${user3.innerState}")

    //генерация метода .toString
    println(user1)

    //диструктивные определения, нам нужны вывести имя фамилию для пользователя
    val user5 = User(name = "name5", lastName = "lastname5")
    println("name = ${user5.name}")
    println("lastname = ${user5.lastName}")
    //в даном случае, мы просто создаем лишнюю переменную (в случае еслио он больше нигде не используется
    //мы можем создать диструктивную переменную
    val (name, lastname) = User(name = "name5", lastName = "lastname5")
    println("name = ${name}")
    println("lastname = ${lastname}")
    //это объявление аналогично слежующиму
    val namee = user5.component1()
    val lastnamee = user5.component2()
    println("name = ${namee}")
    println("lastname = ${lastnamee}")

    //component это функция которая генерируется для какждого свойства в конструкторе

    //другие случаи использования диструктивного определения
    val users = listOf(
        user1,
        user2,
        user3
    )
    //мы хотим из этого списка вывести имена и фамилии пользователей

    users.forEach { (name, lastname) -> println(" диструктивное определение $name $lastname") }

    //попробуем разложить диструктивной функции не дата класс
    //будет ошибка т.к. не определен метод componentN() (Смотри класс Саr)
    val (wheelCount, doorCount) = Car(wheelCount = 4, doorCount = 2, maxSpeed = 200)

    //разложение при использовании map
    //допустим мы хотим проитерироваться по map
    val map = mapOf(
        1 to "1",
        2 to "2"
    )
    for ((key, value)in map){
        key
        value
    }

}