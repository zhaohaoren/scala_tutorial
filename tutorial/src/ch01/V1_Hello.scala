package ch01

import scala.io.StdIn

object V1_Hello {
  // 编译后会生成两个class文件 自动生成public static void main() 方法。
  // 一个className 还有一个className$的class文件 className$的叫做伴生对象。
  // 为什么有两个class 文件，因为scala是一个完全面向对象的语言，不会有static这样的语法。所以要设置两个类 new一个对象来模拟static形式。
  def main(args: Array[String]): Unit = {
    println("Hello world!")
    val input = StdIn.readLine()
    println(s"your input is: $input")
  }
}