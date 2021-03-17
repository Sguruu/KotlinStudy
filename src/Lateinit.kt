import oop.Car

fun main (){
    val car = Car(wheelCount = 4, doorCount = 2,maxSpeed = 200)
    car.openDoor()
  //  car.setDriver(User("driver","lastname"))
    car.closeDoor()

    var height : Int
    println("Введите значение роста: ")
    height = readLine()?.toInt()?:0

}