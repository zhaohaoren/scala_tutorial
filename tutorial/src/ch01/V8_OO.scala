package ch01
package externPackage

import scala.beans.BeanProperty

/**
  * 面向对象
  */
object V8_OO {

  def main(args: Array[String]): Unit = {
    val user: User = new User()
    user.username = "justin"
    user.getAge
    user.setAge(10)
    println(user.username)
  }
}

class User {
  var username: String = _ // 默认初始化

  // 自动生成get和set
  @BeanProperty var age: Int = _

  def login(): Boolean = {
    true
  }
}
