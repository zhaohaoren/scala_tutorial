package ch01

object V14_Class extends App {
  //  def main(args: Array[String]): Unit = {
  //    // 获取类的信息
  //    val user = classOf[User14] // 只所以能直接用classOf因为scala.Predef 默认被导入了当前环境中。
  //    println(user.getInterfaces)
  //
  //    type XXX = User14 // 对类起别名
  //
  //    user.isInstanceOf[User14]
  //  }
}

class User14 {
  println("你好")

}

// 枚举
class Color extends Enumeration {
  var RED = Value(1, "a")
}