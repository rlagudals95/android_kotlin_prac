package com.example.kotlin_prac

// 정적 메소드
// private constructor 다른곳에서 사용불가
class Book private constructor (val id : Int, val name : String)  {

    companion object BookFactory :IdProvider { // interface 상속문법

        override fun getId() :Int { // 인터페이스 상속 함수 구현
            return 777
        }

        val myBook = "new book"

        fun create() = Book(0, myBook)
    }
}


fun main () {

    // private 프로퍼티나 메소드를 읽어 올 수 있게함 자바의 static
    val book = Book.create() // BookFactory 생략가능

    val bookId = Book.BookFactory.getId()

    println("${book.id} ${book.name}")

    // object class
    val car: Car = CarFactory.makeCar(10)
    var car2 : Car = CarFactory.makeCar(200)
    var cars : List<Car> = CarFactory.cars

    println(car)
    println(car2)
    println(cars)

}

interface IdProvider {
    fun getId () : Int
}

//// object class
// CarFactory라는 객체는 앱실행시 딱 한번만 만들어진다 > 싱글톤 패턴 > 메모리 누수 방지
object CarFactory { // class 대신 object
    val cars = mutableListOf<Car>()
    fun makeCar (horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car (val horsePower : Int)