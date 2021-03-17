package oop

import PrintAreaOnChangeDelegate

//конкретный класс (т.к. наследует от абстрактного класса и реализует его свойства и методы)
//интерфейс Comparable позволяет сравнивать 
class Rectangle(
    x: Int,
    y: Int,
    widh: Int,
    height: Int


//можно наследовать множество интерфейсов
) : AbstractShape(x, y), Comparable<Rectangle> {
    override val name: String
        get() = "Rectangle"

    //при изменении ширины и высоты будет печататься площадь до и после
    //добавляются параметры из конструктора
    var widh: Int by PrintAreaOnChangeDelegate(widh)
    var height: Int by PrintAreaOnChangeDelegate(height)

    override fun calculateAre(): Double = widh * height.toDouble()

    //функция сравнения прямоугольников
    override fun compareTo(other: Rectangle): Int {
        return (widh + height) - (other.widh + other.height)
    }

    override fun toString(): String {
        return "Rectangle(width = $widh, height = $height)"
    }

    //создаем функцию которая позволяет складывать два объекта триугольника
    //для каждого оператора есть собсттвенное название
    //для простотра нужна нажать Ctrl + Space
    //в данном случае other это объект который стоит после плюса
    operator fun plus(other: Rectangle):Rectangle{
        return  Rectangle(0,0,widh+other.widh,height+other.height)
    }

    //унарный оператор минус
    operator fun unaryMinus():Rectangle{
        return  Rectangle(0,0,-widh,-height)
    }
}