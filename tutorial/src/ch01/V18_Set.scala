package ch01

import scala.collection.mutable

/**
  * set 无序 不重复
  */
object V18_Set {


  def main(args: Array[String]): Unit = {
    // 不可变的set
    val set = Set(1, 3, 4, 4, 6)
    // add
    println(set + 8)
    println(set - 6)
    println(set.mkString(","))

    // 可变的set
    val mset = mutable.Set(1, 2, 4, 5, 5)


    // 方法和其他都一样
  }

}
