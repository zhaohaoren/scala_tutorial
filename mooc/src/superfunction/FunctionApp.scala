package superfunction

/**
  * 一些高阶函数
  */
object FunctionApp extends App {

  val l = 1.to(4).toList
  println(l)

  //map
  l.map(x => x + 1).foreach(print)
  println()
  l.map(_ * 2).foreach(print) // 对于l每一个元素都乘2
  println()
  //filter
  l.filter(_ > 8).foreach(print)
  //take
  l.take(3).foreach(print) // 取前一个元素
  println()
  //reduce
  println(l.reduce(_ + _))
  println(l.reduceRight(_ - _))
  println(l.reduceLeft(_ - _))
  //flatten
  val f = List(List(1, 2), List(2, 3))
  println(f.flatten)
  // flatMap
  f.flatMap(_.map(_ * 2)) // 先打扁 然后对每一个元素*2 这里的_ 表示打扁后的新list
}
