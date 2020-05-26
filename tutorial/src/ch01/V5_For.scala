package ch01

import scala.util.control.Breaks

object V5_For {
  def main(args: Array[String]): Unit = {
    // 遍历[1,5]  to => 1.to(5) 同理 1+1 => 1.+(1)  在scala中 .可以被简写
    for (i <- 1 to 5) {
      println(i)
    }
    // 遍历[1,5)
    for (i <- 1 until 5) {
      println(i)
    }
    // 遍历带步长
    for (i <- 1.to(5, 2)) {
      println(i)
    }
    // range法。[1,5) to 和 until 内部都是转为Range然后返回的。
    for (i <- Range(1, 5, 2)) {
      println(i)
    }
    // 循环守卫: 相当于循环中加了一个条件判断，符合条件才执行循环体。和在内部判断一样。
    for (i <- 1.to(5) if i % 2 == 0) {
      println(i)
      //continue scala没有continue关键字
    }
    val unit: Unit = for (i <- 1.to(5)) {
      i
    }
    println(unit) // 默认情况下，scala的for都是返回Unit的
    // 循环返回值，yield将每次循环的结果放到一个集合中去。
    val unit2 = for (i <- 1.to(5)) yield i * 2
    println(unit2)
    // break 替代法： scala中没break，该关键字也被认为是非面向对象的，所以没有。
    Breaks.breakable { // 如果方法() 里面要写多行就使用{} 替代。
      // Breaks 可以在import的时候导入._(相当于java静态导入) 就可以这里不用写breaks了 直接 breakable{}
      for (i <- 1.to(5, 2)) {
        if (i > 4) {
          Breaks.break(); // 使用Breaks类的方法来替代。-- 这内部是抛出了一个异常方式来结束循环的。会中断整个方法的执行。所以一定要外面那个breakable。
        }
        println(i)
      }
    }


  }
}
