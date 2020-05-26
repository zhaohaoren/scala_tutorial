package ch01

object V6_Function {

  def main(args: Array[String]): Unit = {

    def test(): Unit = {
      "Hello Scala"
    }

    println(test())

    def test2() = {
      "Hello Scala"
    }

    println(test2())


    // 如果函数体只有一行代码，大括号可以省略。
    def test3() = "Hello Scala"

    println(test3())

    // 如果函数申明中没有参数，() 可以省略
    def test4 = "Hello Scala"

    println(test4) // 如果上面省略，那么下面也要省略，不可以加()

    // 如果明确函数没有返回值，可以省略 "="
    def test5() {
      "Hello Scala"
    }

    println(test5())


    // 匿名函数
    () -> {
      println("Hello Scala")
    }

    // 可变参数
    def test6(name: String*): Unit = {
      println(name)
    }

    test6("Hello", "Scala")

    // 默认参数
    def test7(name: String, age: Int = 20): Unit = {
      println(s"$name - $age")
    }

    test7("justin")
    test7("justin", 30)

    // 带名参数
    def test8(name: String = "Hello", lan: String): Unit = {
      println(s"$name - $lan")
    }

    test8(lan = "Scala")

    /** 返回函数 */
    def f(): Unit = {
      println("function")
    }

    // 这里返回的是一个函数，所以返回值类型为 f的这个函数 ()=> Unit
    def f0() = {
      f _
    }
    // f0() 返回一个函数，()执行函数
    f0()()

    // 闭包
    def f1(i: Int) = {
      def f2(j: Int): Int = {
        i * j // 这里是闭包的核心，i的生命周期被包裹进f2里面了。i理论在f1() 就被弹栈了，但是还能参与f2()计算
      }

      f2 _
    }

    // 函数柯里化 = 上面那个函数的变种简写方式。
    def f3(i: Int)(j: Int) = {
      i * j
    }

    println(f1(3)(4))
    println(f3(3)(4))

    /** 函数参数 */
    // 函数参数的申明： (参数列表)=>返回值类型
    def f4(f: () => Int): Int = {
      f() + 10
    }

    // 使用申明函数做参数
    def f5(): Int = {
      5
    }

    println(f4(f5))
    // 使用匿名函数做参数
    println(f4(() => {
      1
    }))

    // 带参数的函数式编程
    def f7(f: (Int) => Unit): Unit = {
      f(10)
    }
    // 可以简化写lambda
    f7((i)=>{println(i)}) // 可以省略括号 Int 类型申明，因为可以自动依据f7推断
    f7(i=>{println(i)}) // 只有一个参数 () 可以省略
    f7(i=>println(i))  // 可以省略{} 只有一个语句的话
    f7(println(_)) // 如果i只用了一次，可以省略写i 使用 _ 代替
    f7(println) // 如果 只有一个参数，并函数体只有一个语句，参数只用一次的话，那么可以直接省略成这样。
    // 一个更吊的例子
    def f8(f: (Int, Int) => Int): Int = {
      f(10, 10)
    }

    println(f8(
      (x, y) => {x + y}
    ))
    println(f8(_+_))

  }


}
