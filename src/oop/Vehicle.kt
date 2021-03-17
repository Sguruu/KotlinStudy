package oop

//open разрешает наследовать от класса
open class Vehicle(
    val maxSpeed: Int
) {

    //get будет вызываться, когда будем пытаться обратиться к нашему свойству
    var currentSpeed: Int = 0
        get() {
            println("currentSpeed get")

            //field значит вернуть значение нашей переменной
            return field
        }
        //set
        private set(value) {
            println("currentSpeed set $value")
            field = value
        }

    //данная записть говорит, что мы можем образщаться для чтения get, но не можем обращаться для установки
    var fuelCount: Int = 0
        //   private set
        //proteсted, можем установить количество топлива из класса наследника
        protected set


    //Функция которая возвращает названия транспортного средства (полиморфизм)
   open fun gitTitle():String{
        return "Vehicle"
    }


    //создаем доступ просмотра параметров объекта через свойства
    //свойства не можем менять, только поулчать
    //возвращет true если скорость является нулевой
    val isStopped: Boolean
        get() = currentSpeed == 0


    //позволяет соверашть действия в классе, таких блоков может быть несколько
    init {
        //параметр доступен
        // anotherParam

        println("Сar init")
    }

    //создание доп конструктора
    //тип Triple позволяет хранить в себе три значения
    //доп конструктор должен вызывать основной конструктор


    //создание функции скорости
    //чтобы предопределить метод нужно добавить модификатор open
    open fun accelerate(speed: Int) {
        val needFuel = speed / 2

        if (fuelCount > needFuel) {
            currentSpeed += speed
            useFuel(needFuel)
        } else {
            println("Car has no fuel")
        }

    }

    fun decelerate(speed: Int) {
        //функция maxOf, если currentSpeed <0 то выбереться 0 как максимальное из двух чисел
        currentSpeed = maxOf(0, currentSpeed - speed)
    }


    //private fun useFuel(fuelCount: Int) {
    //для возможности предопределить в наследниках
   open protected  fun useFuel(fuelCount: Int) {
        this.fuelCount -= fuelCount
    }

    fun refuel(fuelCount: Int) {
        if (currentSpeed == 0) {
            this.fuelCount += fuelCount
        } else {
            println("you cant refuel with currentSpeed !=0")
        }
    }

}