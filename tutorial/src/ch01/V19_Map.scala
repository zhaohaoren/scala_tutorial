package ch01

import scala.collection.mutable

object V19_Map {
  def main(args: Array[String]): Unit = {
    // 不可变的map - 默认就是不可变
    // "a"->1 在scala 表示kv对
    val map: Map[String, Int] = Map("a" -> 1, "b" -> 2, "c" -> 3)
    // add
    println(map.+("d" -> 4))
    println(map.mkString(","))
    // 可变
    val mMap = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    // 删除key、删除没存在的key也没有问题
    println(mMap - ("a"))
    println(mMap) // 好像没有变化
    // 修改是可以update 也可以+ 进行覆盖。

    // map 获取数据  最后要再加个get
//    println(mMap.get("f").get) 如果key不存在就会报错 scala 防止NPE，scala提供了特殊的类。Option，他有俩个特殊的对象：Some None。Some说明有值。None说明没值。
    println(map.get("f").getOrElse(0)) // 所以应该这么取. orElse 没有就给一个默认值
    println(map.get("b").get)

//    map.mapValues() 这个是不管key，只对map中的values进行运算。


  }
}
