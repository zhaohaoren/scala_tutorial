package ch01

/**
  * 延迟加载
  */
object V7_Lazy {

  def main(args: Array[String]): Unit = {
    lazy val res = sum(1, 1)
    println("----------------------")
    println(res)


    try {
      val r = 10 / 0
    } catch {
      case ex: ArithmeticException => println("不能除以0")
      case ex: Exception => println("发生未知异常")
    } finally {
      println("finally")
    }

  }

  def sum(n1: Int, n2: Int): Int = {


    println(" sum is executed")
    n1 + n2
  }
}
