sealed class SealedColor (
    //свойство
val hex:String
):Drawable{
    //создание объекта только сингол тона
    object  White:SealedColor("#fff")
    object  Black:SealedColor("#fff"){
        override fun draw() {
            println("draw black")
        }
    }

    class CustomColor(hex:String):SealedColor(hex)
    override fun draw() {
        println("draw sealed")
    }
}