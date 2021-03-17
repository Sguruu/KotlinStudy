fun main() {

    1.toBolean()
    1.isPositive

    val nullableInt:Int? = null
    nullableInt.ofDefault(0)
}

//указать класс который мы расширяем
private fun Int.toBolean(): Boolean {
    return this != 0
}

//Extensions свойства

val Int.isPositive: Boolean
    get() = this > 0

private fun Int?.ofDefault(defaultValue: Int):Int{
    return this ?: defaultValue
}