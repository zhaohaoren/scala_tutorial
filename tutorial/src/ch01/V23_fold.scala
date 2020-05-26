package ch01

import scala.collection.mutable

/**
  * 折叠
  */
object V23_fold {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4)

    // 设想这种场景：有个数100 需要和里面的每一个数据进行相加 然后得到一个数。 就需要fold 用来叠加
    // fold(1)(2) : 1 需要操作的额外的那个数  2. 这个数和list之间的操作
    println(list.fold(100)(_ + _))
    // 这个也有fold left 和之等价

    // 1-(2-(3-(4-10))) = 8  内部元素计算的时候会交换。
    println(list.foldRight(10)(_ - _))


    // 应用场景
    // 将两个map进行合并，相同的key做累加，不同的key直接增加 : 所以结果应该是 a=4 b = 2 c = 5 d = 1
    val map1: mutable.Map[String, Int] = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    val map2: mutable.Map[String, Int] = mutable.Map("a" -> 3, "c" -> 2, "d" -> 1)
    // 应该是谁用来新生成一个map，谁就是left的，
    val resMap2 = map1.foldLeft(map2)((map, t) => { // 这里好像只能写foldLeft，使用fold 识别不了类型。

      // 视频讲反了， 这里map2 是用来生成新map的，这样生成的：map2 整个map 和map1 的第一个元素作用，生成新的map 然后再和map1第二元素作用。生成新的map。
      // 注意了: fold 前面的那个list 是用来被迭代的对象，fold() 第一个括号里面的数据 是什么格式的，那么结果应该就是什么格式的。因为是将该元素和list进行迭代计算。最后规约出来应该还是本身的格式。
      // 具体过程

      /*
      map1 : 1,2,3,4
      map2: 【1，2，3，4】
      【1，2，3，4】和 1 => 【2，2，3，4】 所以 左边是map2 右边map1 里面的那个值。
      即：上面那个t是 map1 里面的值，map是整个map2，不信你看打印出来的 println(t)
      所以 fold()() 第二个括号 左边的元素的格式一定是 和 第一个括号的格式是一样的 。
      */
      println(t)

      map(t._1) = map.getOrElse(t._1, 0) + t._2
      map
    })
    println(resMap2)


    // 总结一下： 当存在这种情况：外部数据需要和本源数据做迭代运算，并且当迭代运算中，后面的计算依赖前面的计算结果的，那么就考虑使用fold
  }
}
