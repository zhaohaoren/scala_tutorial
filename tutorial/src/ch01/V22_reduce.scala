package ch01

import scala.io.Source

object V22_reduce {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 5, 6, 7)

    //    list.reduce((left,right)=>{left+right})
    //    简写
    val res = list.reduce(_ + _)
    // 等同于 list.reduceLeft(_+_) 表示从左边来reduce
    println(res)

    // 从右边来reduce 内部其实就是把list 翻转后计算，注意计算中 两个数的位置有交换
    // list = 1,2,3,4
    // 先翻转 4，3，2，1
    // 计算： (3-4) =>  (2-(3-4)) => 1- (2-(3-4))   不是x-y 而是y-x
    val resRight = list.reduceRight(_ + _)
    println(resRight)



    //scala 从一个文件中读取数据
    val lines = Source.fromFile("/Users/zhaohaoren/workspace/code/mine/ScalaProjects/scala-learning/tutorial/resources/input").getLines().toList
    println(lines)
  }
}
