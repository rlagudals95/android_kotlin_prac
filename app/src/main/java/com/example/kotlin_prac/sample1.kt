package com.example.kotlin_prac

// ; 콜론 생략가능 시원~~
fun main () {
    //helloWorld()
    //println(add(4,5))

    // String Template
    val name = "hmk"
    val aka = "good"
    //println("my name is ${name + aka}I'm a boy") // ${} 표시를 쓰면 변수를 사용가능

    //println("this is 2\$a") // 앞에 "\" 백슬래쉬를 쓰면 $를 문자열로 인식

    //println(checkNum(1))
    array();
    loop();
    nullChk();
    ignoreNulls("str");
}

//// 함수

// 자바와 다르게 뭘 리턴하던지 fun으로 시작 void, int , String

// void와 유사함
fun helloWorld () :Unit { // Unit을 굳이 안써도됨
    println("Hello world")

}

// 리턴 타입이 있는 경우
// 변수타입이 : 뒤에 옴
// 변수 타입 첫글자는 대문자 UpperCase
// void가 아닌경우엔 리턴타입 생략 불가!
fun add (a: Int, b: Int) : Int {
    return a+b
}

//// 변수선언

// val, var
// val = value // js의 const java의 static final과 유사
// var = variable // js의 var과 유사
fun hi() {
    val a: Int = 10 // Int 생략해도 타입을 알아서 인식함
    var b: Int = 10
    var name = "hmk" // String 생략해도 타입을 알아서 인식함
    //a = 100 // 재선언시 에러
    //b = 100
    var e : String // 바로 할당을 안할땐 타입을 명시
}

//// 조건식

fun maxBy (a : Int , b:Int):Int {
    if (a > b){
        return a
    } else {
        return b
    }
}

// 삼항연산
fun maxBy2 (a : Int , b:Int):Int = if(a>b) a else b

fun checkNum(score : Int) {
    when(score){
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("i don't know") // else 필수값 x
    }

    var b: Int = when(score){
        1->1 // return
        2->2
        else -> 3 // else 필수
    }

    println("b : ${b}")

    when(score){
        in 90..100 -> println("good!!") // 90 ~ 100
        in 10..80 -> println("not bad") // 10 ~ 80
        else -> println('?')
    }
}

//// Expression(어떤 값을 반환하는 것) vs Statement(ex println 같은 출력문)
// 코틀린의 모든함수는 Expression // void의 경우 Unit을 반환함


//// Array & list

// Array -> 정해진 길이가 있음 메모리가 지정됨
// List -> immutable list(수정불가) & MutableList(수정가능)

fun array () {
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    // array는 mutable 값을 변경가능
    val array2 :Array<Any> = arrayOf(1,"d",3.4f)

    array[0] = 3

    // list는 값 변경불가
    val list2 :List<Any> = listOf(1,"d",11L)

    //list[0] = 2 에러
    var result  = list.get(0) // 값 가져오기 가능

    val arrayList = arrayListOf<Int>()

    arrayList.add(10)
    arrayList.add(20)
    println("어레이 리스트 확인 : "+arrayList) // [10,20]
}


//// loop

// for & while
fun loop () {

    val arr = arrayListOf('a','b', 'b', 'd')

    for ( name in arr){
        println( "arr 원소출력 : "+ name)
    }

    var sum = 0
    for (i in 1..10 step 2){ // step 1,3,5,7,9
        println(i)
        sum += i
    }

    for ((index, name) in arr.withIndex()){ // 배열요소와 index 함께사용
        //print(${index + 1} + "번째 학생"+ ${name})
    }

    for (i in 10 downTo 1){ // step 10, 9 ,8 ,7 , 6
        println(i)
        sum += i
    }

    for (i in 1..100){ // 1 ~ 100 까지 loop
        println(i)
        sum += i
    }

    for (i in 1 until 100){ // 1 ~ 99 까지 loop
        println(i)
        sum += i
    }

    var index = 0;

    while (index < 10){
        index++
        print("index : " + index)
    }

    println("총합" + sum)
}


//// Nullable & NonNull
// 컴파일 시점에 nullPoint Exception을 잡아줌
fun nullChk () {

    var name : String = "hmk"

    var nullName : String? = null // nullable

    var nameInUpperCase = name.toUpperCase() 
    
    var nullNameUpper = nullName?.toUpperCase() // nullName이 null이면 toUpperCase 적용 x & null 반환

    // elvis persley 연산자 ?:

    val lastName :String? = null

    val fullName = name + " "+ (lastName?: "NO lastName") // null 대신 default값 설정가능
    println("폴네임" + fullName)
}

//Null이 아님을 보장 >> !!
fun ignoreNulls (str : String? ) {
    //val NotNull : String = str // error
    val NotNull : String = str!! // 절대 str이 null일리 없다 보장
    val upper = NotNull.toUpperCase() // null이 아님을 확신해 함수 사용가능

    // let > email이 null이 아니라면? 이걸 실행해라
    val email : String? = "ahovmf@naver.com"
    email?.let{
        println("my email is ${email}")
    }
}

