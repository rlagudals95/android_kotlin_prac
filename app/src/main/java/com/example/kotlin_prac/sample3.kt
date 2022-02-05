package com.example.kotlin_prac

class sample3 {
}

fun main () {

    println(square(12))
    println(nameAge("형민", 28))
    
    // 확장함수 사용법
    val a = "hmk good!"
    val b = "android"

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    extendsString("hmk", 28)
    println(calcGrade(91))



    // 람다식을 파라미터로 넘겨보기

    val lamda : (Double) -> Boolean = { number : Double ->
        number == 4.341
    }

    println("람다 넘겨보자 : "+invokeLamda(lamda))
    println(invokeLamda({it > 3.22})) // 이렇게 표현도 가능

    invokeLamda { it > 3.22 } // 함수의 마지막 파라미터가 람다일땐 괄호 생략가능
    
    // 익명 내부 함수

}

//// lamda
// 람다식은 우리가 마지 value 처럼 다룰 수 있는 익명함수!
// 1) 메소드의 파라미터로 넘겨줄 수 가 있다. ) fun maxBt( lamdaFunc )
// 2) 리턴 값으로 사용가능

// 람다의 기본정의
// val lamdaName : Type = {argumentList -> codeBody}

val square = {number : Int -> number*number} // println(square(12)) => 144

val nameAge = {name: String, age: Int ->
    "my name is ${name} I'm ${age}"
}

// 확장함수

val pizzaIsGreat : String.() -> String = { // this는 확장함수를 사용하는 인스턴스
    this + "Pizza is the best!"
}

fun extendsString (name: String, age : Int) : String {

    val introduceMyself : String.(Int) -> String = { // 확장함수사용객체(this).파라미터타입(it) 파라미터가 1개 일땐 it 사용
        "I'm ${this} and ${it} years old" // this는 확장함수가 부른 object it은 int
    }

    return name.introduceMyself(age)
}

// 람다의 Return

val calcGrade : (Int) -> (String) = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "pood"
        else -> "error?"
    }
}

// 람다를 표현하는 방법
// 람다를 파라미터로 받는 함수
fun invokeLamda (lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.2344)
}




