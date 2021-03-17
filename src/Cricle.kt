import oop.Shape


//переиспользование делегата
class Cricle(
    raduis: Int
) : Shape {

    var raduis: Int by PrintAreaOnChangeDelegate(raduis)
    override val name: String = "Cricle"

    override fun calculateAre(): Double {
        return Math.PI * raduis * raduis
    }
}