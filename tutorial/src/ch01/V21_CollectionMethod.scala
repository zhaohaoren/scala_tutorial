package ch01

/**
  * 集合中常用的方法
  */
object V21_CollectionMethod {
  def main(args: Array[String]): Unit = {
    val list = List(1, 5, 3, 4, 4)
    //    list.sortBy()
    //    list.groupBy()
    println(list.sum)
    println(list.max)
    println(list.min)
    println(list.product) // 乘积

    println(list.reverse) // 链表翻转
    val glist: Map[Int, List[Int]] = list.groupBy(x => x) // 依据x=>x 的返回值来分组。 分组后的数据相同放在一个list里面，然后为map
    println(glist)

    val slist = List("11", "12", "22", "23", "45")
    println(slist.groupBy(x => x.substring(0, 1))) // 以字符串第一个值进行分组，还可以基偶分组这种。这个不错啊 可以用哦 函数为参的思想

    println(list.sortBy(x => x)) // 依据依据什么值来分组


    // 指定排序方式：升序还是降序
    // 左边的比右边大 那就是从大到小 降序
    list.sortWith((x, y) => x > y)
    // 下面左边结果小于右边结果 就是从小到大 升序
    list.sortWith((x, y) => x < y)

    // 迭代
    for (elem <- list.iterator) {
      println(elem)
    }

    // map
    val tuples = list.map((_, 1))
    println(tuples)

    // 取多少个
    println(list.take(2))

    // 扁平化
    val flist = List("a b","c d e","m n q")
    println(flist.flatMap(x=>x.split(" ")))


    // 过滤
    println(flist.filter(x=> !x.startsWith("a")))


    // reduce

    // fold

    // zip 拉链，将数据叠一块, 两个list 一一对应上。
    val l1 = List(1,3,4,9) // 如果多一个那么久不会叠一起，因为连接不上
    val l2 = List(2,4,5)
    println(l1.zip(l2))

    // 并集
    println(l1.union(l2))
    // 交集
    println(l1.intersect(l2))
    // 差集
    println(l1.diff(l2))

  }
}
