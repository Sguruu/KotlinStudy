package oop


//унсаледуем ее от инторфейса
//в абстрактном кассе не обязательно реализовать методы и перменные интерфейса
abstract class AbstractShape(
    private var x: Int,
    private var y: Int
) : Shape {

    // abstract val name : String
    //абстрактный метод
    // abstract fun calculateArea(): Double
    fun moveToPosition(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun printPosition() {
        println("Shape with posotion (x=$x, y = $y")
    }

}