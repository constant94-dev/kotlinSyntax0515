package com.example.kotlinsyntax

fun look3(){
    val dog: Animal = Dog()
    val cat = Cat()

    // 강제로 타입 캐스팅을 할 때 'cat as Dog' 사용할 수 있다
    // 실제로 Dog 만들었기 때문에 dog 타입이 맞다
    if (dog is Dog) {

        println("멍멍이")
    }

    // 서로 타입을 비교 했을 때 다른 타입일 경우
    if (dog is Cat) {
        println("멍멍이")
    }

    val box = Box<Int>(10)
    val box2 = Box("dfdfdf")
    println(box.value)
} // look3 function end

// 코틀린은 기본 클래스도 상속이 불가능
// open 키워드를 사용해 상속 가능
open class Fuck

class SuperFuck : Fuck()

// 코틀린은 상속을 받아도 오버라이드가 닫혀있다
// open 키워드를 사용해 오버라이드를 열어준다
abstract class Animal {
    open fun move() {
        print("이동")
    }
}


interface Drawable {
    fun draw()
}

// interface 는 콤마로 구분하여 붙여주면서 사용 가능하다
class Dog : Animal(), Drawable {
    override fun move() {
        println("껑충")
    }

    override fun draw() {
        TODO("Not yet implemented")
    }
}

class Cat : Animal() {
    override fun move() {
        println("살금")
    }
}

// 제너릭 선언 방법
class Box<T>(val value: T) {

}