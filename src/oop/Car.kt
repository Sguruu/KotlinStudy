package oop

import Engine
import User

//пример наследования, при наследовании необходимо указать конструкотор супер класса или роительского класса
class Car(
    val wheelCount: Int,
    val doorCount: Int,
    maxSpeed: Int
    //функции высшего порядка
    //val callback:()->Unit
    //
) : Vehicle(maxSpeed) {
    var isDoorOpen: Boolean = false
        private set

    private lateinit var driver: User

    //инициализирования дивгателя
    //параметр lazy
    private val engine by lazy {
        Engine()
    }

    //функция componentN
    //operator - перегрузка оператора
    operator fun component1(): Int = wheelCount
    operator fun component2(): Int = doorCount

    fun openDoor() {
        if (!isDoorOpen) {
            println("door is opened")
        }
        isDoorOpen = true
    }

    //функции высшего порядка
    fun openDoor1(openCallback: () -> Unit = { println("open door") }) {
        if (!isDoorOpen) {
            openCallback()
        }
        isDoorOpen = true
    }
//

    //функции высшего порядка
    fun closeDoor1(closeCallback: () -> Unit = { println("close door") }) {
        if (isDoorOpen) {
            closeCallback()
        }
        isDoorOpen = false

    }

    //
    fun closeDoor() {
        if (isDoorOpen) {
            println("door is closed")
            //проверка на инициализацию поля
            if (::driver.isInitialized) {
                println("driver = ${driver}")
            }
        }
        isDoorOpen = false

    }

    //override предопределение метода
    override fun accelerate(speed: Int) {
        engine.use()
        if (isDoorOpen) {
            println("you cant accelerate with opened door")
        } else {
            //реализация метода из родительского класса
            super.accelerate(speed)
        }
    }

    //перегузка, объявление функции с таким же именем, но с другими параметрами
    fun accelerate(speed: Int, force: Boolean) {
        if (force) {
            if (isDoorOpen) println("you cant accelerate with opened door")
            super.accelerate(speed)
        } else {
            accelerate(speed)
        }

    }

    fun setDriver(driver: User) {
        this.driver = driver
    }

    override fun useFuel(fuelCount: Int) {
        super.useFuel(fuelCount)
    }

    override fun equals(other: Any?): Boolean {
        //сравнение двух объектов по ссылке
        if (this === other) return true
        //проверка является ли этот класс текущим классом
        if (javaClass != other?.javaClass) return false

        //приведение типа Any к типу Car
        other as Car

        //проверка по всем полям
        if (wheelCount != other.wheelCount) return false
        if (doorCount != other.doorCount) return false
        if (isDoorOpen != other.isDoorOpen) return false

        return true
    }

    override fun hashCode(): Int {
        var result = wheelCount
        result = 31 * result + doorCount
        result = 31 * result + isDoorOpen.hashCode()
        return result
    }

    //объекты компаньона
//обычно используют для хранения констант
    companion object {
        val default = Car(wheelCount = 4, doorCount = 4, maxSpeed = 200)

        fun createWithDeaultWheelCount(doorCount: Int, maxSpeed: Int): Car {
            return Car(wheelCount = 4, doorCount = doorCount, maxSpeed = maxSpeed)
        }
    }

}


//************************
// : Vehicle//()
//{
//пример создания дополнительного консруктора
//если у роителя есть конструктор мыо бязаны указать его в нашем доп конструкторе
// constructor():super(100){

//}
//}
//888888888888888888888888888888888888888