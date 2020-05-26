package ch01

object V13_interface {
  def main(args: Array[String]): Unit = {
    // 动态混入
    val mysql: Mysql2 = new Mysql2() with Op2
    mysql.insert()
  }
}

trait Op2 /*extends Exception*/ { // 特质是可以继承类的
  this: Exception => // 指定特质的使用范围，指定特质只在该方法内使用
  def insert(): Unit = {
    println("insert")
    this.getMessage // 获取异常信息
  }
}

// 我们在开发完成后期发现：Mysql 也需要一个insert的方法，如果我们在类上面 Mysql extends Op 那么违反了OCP开闭原则
// 这时候就需要我们的动态混入来实现了。 如上
class Mysql2 extends Exception with Op2 {

}