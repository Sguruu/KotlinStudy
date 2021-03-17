/*fun main (){
val genericsObject = GenericsClass<String>()
    genericsObject.updateItem("")
    //в данном случае компилятор не может вывести тип автоматичски

    val genericsObject2 = GenericsClass2("string value")
    genericsObject2.updateItem("sasdasd")

    val genericsObjects3 = GenericsClass3 <String,Int>("")

    printGenericObject("dsa")
    printGenericObject<String?>("dsa")

    val genericsObjects4 = GenericsClass4<Double>(2.0)
   // genericsObjects4.updateItem(2.3)
    val genericsObjects5 = GenericsClass4<Float>(0f)
   // genericsObjects5.updateItem(2.3)

  println(sumGeneric(genericsObjects4,genericsObjects5))

    //функция дженерик
    printGenericObject<String?>("dsa")

    updateCintrVariant(ContrvariantClass<Any>(234))

}*/

//указываем параметр типа T
class GenericsClass <T>{
    var item: T? = null
    private set

    fun updateItem(newIten: T){
        item = newIten
    }
}

class GenericsClass2 <T>(
    defaultValue: T
){
    var item: T? = defaultValue
        private set

    fun updateItem(newIten: T){
        item = newIten

    }
}

//для класса можно указать несколь параметра типа
class GenericsClass3 <T,R>(
    defaultValue: T
){
    var item: T? = defaultValue
        private set

    fun updateItem(newIten: T,returnItem:R):R{
        item = newIten
        return returnItem

    }
}

//обобщенные функции
fun <T> printGenericObject(item:T){
    println(item.toString())
}

//ограничение типа
//делаем его конвариантным
//при использовании конвариантного класса мы можем использовать тип T только в
//в исходящих позициях, т.е. функция может возвращать значения типа Т но не принимать их
class GenericsClass4 <out T : Number, in R>(
    defaultValue: T
){
//если свойство открытое, то говорят что свойсвто находится в инвариантной позиции
  //  var item: T = defaultValue
    //    private set
//чтобы работать в конваринтом, это свойство должно быть закрытым
    private var item: T = defaultValue
    private set

    fun getItem(): T {
        return item
    }

    fun setItem(newR:R){
        
    }


}
//fun  sumGeneric (a:GenericsClass4<Number>,b:GenericsClass4<Number>): Int {
  //  return a.getItem().toInt() + b.getItem().toInt()
//}


//контрвариантные параметры (возможно использовать только во входящих позициях)
class ContrvariantClass<in T>(defaultValue: T){
    private var item: T = defaultValue

    //параметр типа T находится во входящий позиции
    fun setItem (newItem: T){
        item = newItem
    }
}
//функция которая принимает параметры контрвариантного класса с типом
//number
fun updateCintrVariant(input: ContrvariantClass<Number>){
    input.setItem(2.2)
}
//работа с обобщеными типами актуальна для коллекций