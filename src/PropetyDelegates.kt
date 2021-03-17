import oop.Car
import oop.Rectangle
import oop.Shape
import kotlin.reflect.KProperty
import kotlin.properties.ReadWriteProperty as ReadWriteProperty1

fun main (){
val rectangle = Rectangle(0,0,10,20)
    rectangle.widh = 15
    rectangle.height = 50

    //проверка переиспользования делегата
    val circle = Cricle(10)
    circle.raduis = 20

    //проверка делегата lazy
    val car = Car(wheelCount = 4,doorCount = 4,maxSpeed = 400)
    //двигатель не создается
    car.openDoor()
    car.closeDoor()
    //после ускорения двишаьель инициализируется
    car.accelerate(20)

}

//делигированное свойство (параметр Shape название, параметр T - тип)
//создание собственного
class PrintAreaOnChangeDelegate <T> (
    private var value: T
): ReadWriteProperty1<Shape,T> {
    //возвращает наше свойство
    override fun getValue(thisRef: Shape, property: KProperty<*>): T = value

    //что будет производиться при установки свойства
    //объект тип Shape,объект в нутри которого будет использовано делегированное свойство
    override fun setValue(thisRef: Shape, property: KProperty<*>, value: T) {
        println("before change property ${property.name} = ${thisRef.calculateAre()}")
        this.value = value
        println("after change ${property.name} = ${thisRef.calculateAre()}")
    }

}