object FunctionApp {


  def main(args: Array[String]): Unit = {

    println(add(2, 4))
    println(three())
    // 当函数没有参数的时候，我们可以不加括号
    println(three)
    sayHello
    sayName() // 这个括号是不可以被省略的
    sayName("king")
    speed(time = 10, distance = 100)
    println(sum(1, 2, 3, 4, 5))
    val x = 1
    val a = if (x > 0) true else false
    println(a)


  }

  def add(x: Int, y: Int): Int = {
    x + y
  }

  // 可以不写返回值类型，会自己类型推到
  // 如果只有返回值，可以不用括号
  def three() = 1 + 2

  // unit 没有返回值
  def sayHello() = {
    println("hello")
  }

  /**
    * 参数
    */

  //默认参数
  def sayName(name: String = "justin") = {
    println(name)
  }

  // 命名参数 : 函数调用的时候指定参数名，则不需要按照顺序传参
  def speed(distance: Float, time: Float): Float = {
    distance / time
  }

  // 可变参数
  def sum(numbers: Int*): Int = {
    var res = 0
    for (number <- numbers) {
      res += number
    }
    res
  }

  /**
    * 循环表达式
    * to
    * Range
    * until
    */
  def cycle() = {
    // []
    1 to 10
    1.to(10)
    //[)
    Range(1, 10)
    Range(1, 10, 2) //步长为2 不可以为0
    //[)
    1 until (10)
    1.until(10)
    1.until(10, 2)

    for (i <- 1 to 10 if i % 2 == 0) {
      println(i)
    }

    val datas = Array("a", "b", "c")
    // 相当于map
    datas.foreach(data => println(data))

  }
}
