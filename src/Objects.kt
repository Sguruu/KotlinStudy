import oop.Car
import oop.Vehicle

fun main() {
    Cars.nissan
    Cars.someMehod()
    Cars.accelerate(20)

    //доступ к объеку компаньена
    Car.default
    Car.createWithDeaultWheelCount(4,200)

    val a =Car
    val b = Cars
}

//сингл тон
private object Cars : Vehicle(100) {
    val toyota = Car(wheelCount = 4, doorCount = 4, maxSpeed = 200)
    val nissan = Car(wheelCount = 4, doorCount = 4, maxSpeed = 200)

    fun someMehod() {}
}