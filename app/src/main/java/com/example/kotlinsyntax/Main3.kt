package com.example.kotlinsyntax


fun look2() {
    val john = Person("John", 20)
    println(john.name)
    println(john.age)

    // getter, setter 따로 만들지 않고 var or val 조정으로 사용할 수 있다
    john.age = 23

    val john2 = Person("John", 20)
    val john3 = Person("John", 20)

    println(john2)
    println(john3)
    println(john2 == john3)

    val john4 = Person2("john4", 10)
    println(john4.hobby)
}

// Person 객체를 새롭게 사용하면 주소가 다르지만 data 를 선언하면 내부 값이 같을 때 true 를 반환한다.
data class Person(
    val name: String,
    var age: Int,
)

// 생성자로 파라미터를 받고 무언가 더 작업하고 싶을 때 내부에 init 함수를 만들 수 있다
class Person2(
    val name: String,
    var age: Int,
) {
    // 외부에서 hobby 를 접근하지 못하게 하기 위해서 private set 을 붙여준다
    var hobby = "축구"
        private set
        get() = "취미: $field" // field 를 사용해서 hobby 값 을 사용할 수 있다

    init {
        println("init")
    }

    fun some() {
        hobby = "농구"
    }
}