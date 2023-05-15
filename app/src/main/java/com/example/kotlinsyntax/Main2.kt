package com.example.kotlinsyntax

import java.util.Scanner
import kotlin.random.Random

// 상수
// 상수는 재 대입이 불가능
// java 의 final 과 동일
// java 와는 다르게 클래스 파일 없이 선언 가능
val num = 20

// 컴파일 타임 상수
// Main() 보다 우선해서 컴파일된다
const val co_num = 20

fun look() {
    // 출력
    print("Hello World!")
    println("Hello World!")

    // 변수 미 지정
    // 변수는 재 대입이 가능
    // 코틀린은 타입을 추론하는 기능을 가지고 있어 별도의 타입을 지정하지 않아도 된다.
    var i = 10
    var name = "상준"
    var point = 3.3

    // 변수 타입 지정
    var j: Int = 10
    var name2: String = "상준"
    var point2: Double = 3.3

    // java 에서는 Long 변수에 int 변수를 대입할 수 있지만 코틀린은 안된다
    // 타입 캐스팅이 필요함
    var a = 10
    var b = 20L
    var ex_name = "10"

    b = a.toLong()
    a = b.toInt()
    ex_name = a.toString()
    a = ex_name.toInt()

    // 문자열 다루기
    var ex2_name = "상준"
    println(ex2_name.uppercase())
    println(ex2_name.lowercase())
    println(ex2_name[0])
    println("제 이름은 $name 입니다.")
    println("제 이름은 ${name + 10}입니다.")

    // 알고리즘 관련 함수
    var c = 10
    var d = 20
    println(java.lang.Integer.max(c, d)) // java 제공 함수
    println(kotlin.math.min(c, d)) // kotlin 제공 함수

    val randomNumber_int = Random.nextInt(0, 100) // 0(inclusive) ~ 99(exclusive)
    println(randomNumber_int)

    val randomNumber_double = Random.nextDouble(0.0, 1.0) // 0.0(inclusive) ~ 0.9(exclusive)
    println(randomNumber_double)

    val reader = Scanner(System.`in`) // 코틀린에서 사용할 수 없는 in 키워드는 `in` 형태로 사용할 수 있다.
    var readA = reader.nextInt() // 숫자 입력
    var readB = reader.next() // 문자 입력

    println(readA)
    println(readB)

    var if_i = 5

    // 코틀린에서 조건문은 when 문으로 변경 가능
    // 조건문의 결과를 변수로 받을 수 있다
    // java 에서는 조건문 자체가 값으로 치환이 안되서 사용할 수 없다
    when {
        if_i > 10 -> {
            print("10 보다 크다")
        }

        if_i > 5 -> {
            print("5 보다 크다")
        }

        else -> {
            print("")
        }
    }

    var test = if (if_i > 10) {
        "10 보다 크다"
    } else if (if_i > 5) {
        "5 보다 크다"
    } else {
        "!!!!"
    }

    print(test)

    // 삼항연산 java -> boolean result = i > 10 ? true : false;
    // 삼항연산 kotlin
    var tree = 5
    val result = if (tree > 10) true else false

    // 반복문
    val for_items = listOf(1, 2, 3, 4, 5)

    for (item in for_items) {
        println(item)
    }

    for_items.forEach { item ->
        println(item)
    }

    // java 의 반복문은 3 이전까지 돌지만 kotlin 은 3까지 모두 돈다.
    for (i in 0..(for_items.size - 1)){
        print(i)
        print(for_items[i])
        // break, continue 둘 다 지원함
    }

    // listOf() 함수는 변경이 안되는 리스트
    // mutableListOf() 함수는 변경이 되는 리스트
    // 타입 추론이 가능하기 때문에 제너릭 생략이 가능
    val items = mutableListOf(1, 2, 3, 4, 5)

    items.add(6)
    items.remove(3)

    // 타입 추론을 사용하지 않아 생략을 안한다면
    val items2: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

    // 배열
    val items3 = arrayOf(1, 2, 3)
    items3.size
    items3[0] = 10
    items3.set(0, 10) // java 형태이기 때문에 지원은 하지만 권장하지는 않는다

    // 예외처리
    try {
        val item = items3[4]
    } catch (e: Exception) {
        println(e.message)
    }

    // 코틀린 nullSafety
    var name_check: String? = null
    name_check = "상준"

    name_check = null

    var name_check2: String = ""
    if (name_check != null) {
        name_check2 = name_check
    }

    name_check2 = name_check!! // 개발자가 임의로 null 이 아님을 선언한 것 (권장하지 않는다)

    // name 이 null 이 아니라면 실행한다
    name_check?.let {
        name_check2 = name_check
    }

    println(sum3(a = 10, b = 20))
    println(sum3(b = 10, a = 20))
} // look function end

// 인자 값 int a, b 를 받고 리턴 타입을 Int 로 하겠다.
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 함수 내부 로직이 한줄일 때
// 리턴 타입 생략가능
fun sum2(a: Int, b: Int): Int = a + b

// 인자를 3개 받을 때 default 값을 지정하면 꼭 3개를 모두 받지 않아도 된다
fun sum3(a: Int, b: Int, c: Int = 0) = a + b + c

