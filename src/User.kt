data class User(
    val name: String,
    val lastName: String,
//функции высшего порядка работа с лямбдой
    val age: Int = 0
//
) {
    var innerState: String = ""

    //функции высшего порядка работа с лямбдой
    fun getFullnameLength() =  "$name$lastName".length
//

}