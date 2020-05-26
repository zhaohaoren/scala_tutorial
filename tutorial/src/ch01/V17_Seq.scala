package ch01

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 序列
  */
object V17_Seq {
  def main(args: Array[String]): Unit = {

    // List 不可变
    val list: List[Int] = List(1, 2, 3, 4)
    println(list(0))
    // 大部分操作和Array是一样的
    val list1 = list :+ 1
    println(list1.mkString(","))


    // ++  添加集合
    val list2 = list ++ list1
    println(list2.mkString("."))
    // 添加元素
    val list3 = list.::(9)
    // 将789加在前面，这个:: 计算是从右往左的
    var list4 = 7 :: 8 :: 9 :: list
    // 这样是将list1 也当成一个元素 然后加入到 list5中去了，
    var list5 = 6 :: list1 :: list
    // 如果想让数组的元素 压平进入新数组： 使用::: 三个冒号
    var list6 = 6 :: list1 ::: list
    println(list3.mkString(","))
    println(list3.mkString(","))
    println(list4.mkString(","))
    println(list5.mkString(","))
    println(list6.mkString(","))
    // 空集合的表示方法
    println(List())
    println(Nil)

    // 修改集合
    println(list.mkString(","))
    var list7 = list.updated(1, 0)
    println(list7.mkString(","))
    // 查询
    for (ele <- list) {
      println(ele)
    }
    // 删除数据
    var list8 = list7.drop(2) // drop list的前几个？
    println(list8.mkString(","))

    // 可变集合
    val buffer = ListBuffer(1, 3, 4, 5, 6)
    // 方法和上面一样，只是使用的一直都是原地址的内存


    // 集合的属性
    println(buffer.head) // 集合开头
    println(buffer.tail) // 集合结尾：除了头部以外的所有元素
    println(buffer.last) // 集合最后一个元素
    println(buffer.init) // 集合除最后一个所有的元素


    //队列 一定是可变的
    val q = mutable.Queue(1, 3, 4, 5, 6, 9)
    q.enqueue(5) //放数据
    val i = q.dequeue()
    println("取数据" + i)
    println("取完后的q：" + q)

  }
}
