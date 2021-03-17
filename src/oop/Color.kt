package oop

import Drawable

enum class Color (
    val hex:String
) : Drawable{
    //вызов конструкторы перечисления
    WHITE("#fff"),
    BLACK("#000"),
    //переопределение метода внутри самого атрибута
    RED("f00"){
        override fun draw() {
            println("draw red color")
        }
    },
    BLUE("00f");
    //; ставиться после оканчивания перечисления
    fun someMethod(){

    }

    override fun draw() {
        println("draw color")
    }

    //т.к. перечисления это обчные классы в них можно определить компаньены
    companion object{
        fun fromName(name:String):Color?{
            //прохоидит по всем цветам и ищет тот цвет, который мы ему передали
            return values().find { it.name == name.toUpperCase() }
        }
    }
}