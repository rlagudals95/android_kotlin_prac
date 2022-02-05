package com.example.kotlin_prac

//// Class

// java와 다르게 class와 이름을 안맞춰 줘도 된다.
// 코틀린도 상속은 1개만 받을 수 있다.
open class Human (val name : String = "defaultName") { // 생성자 함수 쓸경우 constructor 생략가능
// open을 써줘야 상속가능
    constructor(name: String, age:Int) : this(name) { // 부 생성자
        println("my name is ${name} & ${age} years old");
    }

    init { // 인스턴스 생성 시 실핼
        println("new human has been born!!")
    }

    // 생성자 자바의 경우
    // Human () { }

    // 프로퍼티 생략가능
    // val name = "hmk" //

    // 메서드
    fun eatingCake () {
        println("This is so YUMYYYY~");
    }

    open fun singAsong () { // open을 써야 override 가능
        println("lalalallala")
    }
}

fun main () {
    val human = Human("hmk") // new 필요없는 인스턴스
    val stranger = Human()// dafault 값을 줘 에러가 안뜬다
    human.eatingCake() // 메서드 호출
    
    // 주 생성자 부터 실행
    val mom = Human("jjj", 52)

    //프로퍼티 호출
    println("name is  ${stranger.name}")

    val korean = korean()
    korean.singAsong() // 상속 받았기 때문에 부모 클래스 메소드 사용가능
}

// 상속
class korean : Human() { //extends 대tls
    override fun singAsong () {
        super.singAsong() // 부모 것도 사용하고 싶다면!
        println("hahaha");
        println("my name is ${name} override") // Human에서 상속 받았다 default 값이 있어서 에러가 안뜬다
    }
}