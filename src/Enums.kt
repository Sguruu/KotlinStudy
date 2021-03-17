import oop.Color

fun main() {
    val color = Color.BLACK.hex
    Color.RED.draw()

    //У перечисления есть статичный методо .values который возвращает массив всех перечислений
    Color.values().forEach {
        it.draw()
        //свойство name
        //выводит название самих объектов
        println(it.name)

        //свойство ordinal индекс элемента в массиве
        println(it.ordinal)
    }

    //также можно получить объект перечисления через метод valueOf
    Color.valueOf("RED")
    println("какой то текст "+Color.values()[Color.RED.ordinal])

    //вернет null ошибки не будет (мы сами созадли, такой метод)
    Color.fromName("232423423")


    //Seald классы
    SealedColor.Black
    SealedColor.CustomColor("#ff0")
}

//как работа перечесдений работает внутри выражений ven
fun invertColor(color: Color): Color {
    //можем через when проверить каким цветом является объект типа Color и предоставить инвертированный цвет
    return when (color) {
        Color.WHITE -> Color.BLACK
        Color.BLACK -> Color.WHITE
        Color.RED -> Color.BLUE
        Color.BLUE -> Color.RED
        //сработает в случаии добавления нового цвета
        //но лучше так не делать
        else -> Color.BLACK
    }
}

fun invertColorSealed (color: SealedColor):SealedColor{
    return when (color){
        SealedColor.Black -> SealedColor.White
        SealedColor.White -> SealedColor.Black
        //можем проверить что объект SealedColor является объектом CustomColor
        //тогда можем инвертировать этот custom Color
        is SealedColor.CustomColor -> {
            SealedColor.White

        }
    }
}