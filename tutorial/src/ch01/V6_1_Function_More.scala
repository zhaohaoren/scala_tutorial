package ch01

object V6_1_Function_More {

  def main(args: Array[String]): Unit = {

    // 对list里面每一个元素+1，注意里面的"abc"字符串
    val list = List(1, 2, 3, 4, "aaa")
    //    可以使用map方式
    val list2 = list.map(x => {
      if (x.isInstanceOf[Int]) {
        x.asInstanceOf[Int] + 1
      }
    }).filter(x => x.isInstanceOf[Int])
    println(list2)
    //    还可以使用偏函数来实现 PartialFunction
    //    偏函数：对于符合某个条件的情况做逻辑操作，而不是对全部的元素做操作，所以叫“偏”    //    比如上面 list 我只操作int型的
    val partF1 = new PartialFunction[Any, Int] {
      // 满足情况的条件
      override def isDefinedAt(x: Any): Boolean = {
        x.isInstanceOf[Int]
      }

      // 满足情况执行的逻辑
      override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 1
    }
    // 使用collect指定偏函数
    val list3 = list.collect(partF1)
    println(list3)
    // 偏函数简化 { case i: Int => i + 1 } case的语句就是偏函数，如下就是满足i是int的就可以执行这个函数。也是模式匹配。
    val list4 = list.collect { case i: Int => i + 1 }
    println(list4)


    // 控制抽象 -- 很深的东西看不懂
  }
}
