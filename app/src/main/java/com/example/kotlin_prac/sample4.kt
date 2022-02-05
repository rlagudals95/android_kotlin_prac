package com.example.kotlin_prac


//// Data
// pojo class 모델이 되는 클래스 > 메서드가 없고 틀 역할을 하는 클래스 jpa 모델같은? lombok을 이용한?
// 이게 끝...! getter setter @Data 어노테이션 다 필요없다 대박!
data class Ticket(val companyName : String , val name : String , var date : String, val seatNumber : Int)

class TicketNormal(val companyName : String , val name : String , var date : String, val seatNumber : Int)

fun main () {
    val ticketA = Ticket(  "asiana", "hmk", "2022-02-28", 7  )
    val ticketB = TicketNormal("asiana", "hmk", "2022-02-28", 7 )

    println(ticketA) // 객체 내용 확인가능
    println(ticketB)
}