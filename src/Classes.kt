import oop.*

fun main() {
    //полное имя класса
    //oop.Car

    //создание объекта класса
    val tesla = Class(wheelCount = 4, doorCount = 2, bodyLenght = 500, bodyWidth = 200, bodyHeight = 150)

    println("tesla wheelCount = ${tesla.wheelCount}, doorCount = ${tesla.doorCount}, currentSpedd = ${tesla.currentSpeed}")

    // tesla.currentSpeed = 234

    println(tesla.currentSpeed)

    // val nissan = Car (doorCount = 2)
    // создание через доп конструктор
    val nissan = Class(4, 2, Triple(500, 200, 150))

    //вызов метода на объекте класса

    tesla.accelerate(100)
    println(tesla.currentSpeed)
    tesla.decelerate(50)


    //  println("tesla currentFuel = ${tesla.fuelCount}")


    //Наследование********************************************************
    //создадим элемент класса Car
    //программа которая аккомулирует езду на автомобиле
    val tTesla = Car(wheelCount = 4, doorCount = 2, maxSpeed = 150)

    //пример как можно сократить запись ниже с помощью скоп функции функции with
    with(tTesla){
        openDoor()
        accelerate(100)
        accelerate(100,true)
        refuel(10)
        isDoorOpen
        closeDoor()
        accelerate(100)
        decelerate(50)
    }

    //еще одна функция скоп (позволяют рабботать в контексте данного объекта
    tTesla.let {
        it.accelerate(100)
        it.refuel(10)
        it.isDoorOpen
        it.closeDoor()
        it.accelerate(100)
        it.decelerate(50)
    }
    tTesla.accelerate(100)
    tTesla.refuel(10)
    tTesla.isDoorOpen
    tTesla.closeDoor()
    tTesla.accelerate(100)
    tTesla.decelerate(50)

    //род класс
 //   val vehicle = Vehicle(maxSpeed = 200)
    // vehicle.toString()


    //объекты классов наследования могут выступать в качестве объектов родительского класса
    val vehicle:Vehicle = tTesla

    //для проверки объкта , какого он класса существует конструкция is
    println("vehicle is car = ${vehicle is Car}")
    println ("car is vehicle = ${ tTesla is Vehicle}")
    //какоето транспортное средство, созданное через конструктор Vehicle является объектом класса Car
    println("vehicle is car = ${ Vehicle(maxSpeed = 100) is Car}")


    //приведение типов (транспортное средство машиан ? )
    //привели мне объект vecgicle к типу Car
    //val newCar: Car = vehicle as Car
    //newCar.openDoor()

    //безопасное приведение типов
    val newCar: Car? = vehicle as? Car
    newCar?.openDoor()

    //Полиморфизм, возможность использовать предопределенные методы в потомках, когда вы используете род класс
    val polVehicle:Vehicle = Car(wheelCount = 4,doorCount = 4,maxSpeed = 100)
    println("Полиморфизм polVehicle.gitTitle() ${polVehicle.gitTitle()}")


    listOf<Vehicle>(
        Vehicle(maxSpeed = 100),
        Car(wheelCount = 4,doorCount = 4,maxSpeed = 100),
        Airplane(maxSpeed = 100)
    ).forEach{
        println(it.gitTitle())
    }

    //Полиморфизм работет именно на этапе выполнения, в момент компиляции мы не знаем какой будет использоваться метод


    //Абстрактный класс
    val shape = Rectangle(x = 1, y = 2, widh = 2, height = 2)
    shape.printPosition()
    shape.moveToPosition(x = 2, y = 2)
    shape.printPosition()

        //  println("shape area = ${shape.calculateArea()}")
    println("shape area = ${shape.name}")



    //Интрефейс

    //пример использования стандартный
    val list: List<Int> = listOf()

    val largeRectangle = Rectangle(x = 1, y = 1, widh = 20, height = 30)

    println("shape <= largeRectangle (${shape <= largeRectangle})")

    val set: MutableSet<Rectangle> = sortedSetOf(
        largeRectangle,
        shape
    )
    println(set)


    //Анонимный класс
    val shapeAn = object  : Shape {
        val additionalField = 123
        fun additionalMethod() = 234

        override val name: String = "anonymos shape"


        override fun calculateAre(): Double = 0.0

    }

    shapeAn.additionalField
    shapeAn.additionalMethod()

    val AnFun = getAnonym()

}

//вынисени объявления анонимного класса в функицию
//важно отметить. что при испольовании анонимного класса из функции
//не возможно использовать его параметры
fun getAnonym():Shape = object  : Shape{
    val additionalField = 123
    fun additionalMethod() = 234

    override val name: String = "anonymos shape"


    override fun calculateAre(): Double = 0.0
}