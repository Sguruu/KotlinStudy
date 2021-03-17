import java.lang.Exception
import java.lang.NullPointerException

fun main() {
    try {
        println("before")
        functionWithException()
        print("after")
    } catch (t: NullPointerException) {
        println("cath null execption with info = ${t.message}")
    } catch (t: Exception) {
        println("cath execption with info = ${t.message}")
    }
    //указвается имя и тип исключения
    catch (t: Throwable) {
        println("cath Throwable with info = ${t.message}")
    } finally {
        //блок кода будет выполнен в любом случае
        println("finally")
    }

    println("----")
    functioOuter()

    //ловим другие исключения NullPointerException

}

fun functioOuter() {
    println("functioOuter before")
    functionWithExceptionHalding()
    println("functioOuter after")
}

fun functionWithExceptionHalding() {
    println("functionWithExceptionHalding before")
    try {
        functionInner()
    } catch (t: Throwable) {
        println("cath Throwable with info = ${t.message}")
    }
    println("functionWithExceptionHalding after")

}

fun functionInner() {
    println("funcionInner before")
    functionWithException()
    println("funcionInner after")
}

fun functionWithException() {
    println("functionWithException before")
    throw Exception("exception with additional info")
    println("functionWithException after")
}