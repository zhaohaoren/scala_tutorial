package ch01

object V20_Tuple {
  def main(args: Array[String]): Unit = {
    val tuple: (String, Int, String) = ("justin", 20, "man")
    // 访问tuple数据
    println(tuple._1)
    // 元组最大给到22个
    // 遍历tuple
    for (elem <- tuple.productIterator) {
      println(elem)
    }
    // 元组也叫对偶，类似于map的关系，所以map可以用元组来构造
    val map = Map((1, "a"), (2, "b"))
    println(map.mkString(","))
    map.foreach(t => println(t._1 + "=" + t._2))
  }
}
