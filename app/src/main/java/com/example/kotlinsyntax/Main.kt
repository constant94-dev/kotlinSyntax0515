package com.example.kotlinsyntax

// 'suspend' 함수는 다른 'suspend' 함수에서 사용할 수 있지만 main 을 'suspend' 로 만드는 것은 올바르지 않다
fun main() {
    // myFunc 함수의 '{}' 내부의 함수를 전달해서 실행한다
    // 코틀린에서 전달하는 인자가 함수인 경우 아래와 같이 밖으로 빠질 수 있다
    // 람다식 표기법이 활용된것이다
    // '고차 함수'라고 불린다
    myFunc2(10) {
        println("함수 호출")
    }
}

// input, output 없는 함수 선언
// 인자값의 함수가 기본값이 있는 경우 함수를 사용 안해도 된다.
// 'suspend' 함수는 정지 함수라고 불리우며 해당 함수가 끝날 때까지 기다려야 한다
// 'suspend' 함수는 main 스레드 안에서 실행할 수 없다
fun myFunc2(a: Int, callBack: () -> Unit = {}) {
    println("함수 시작!!!")
    callBack()
    println("함수 끝!!!")
}
