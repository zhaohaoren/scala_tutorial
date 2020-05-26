package superfunction

/**
  * String 高级操作
  */
object StringApp extends App {
  val s = "Hello"
  val name = "Justin"

  //插值
  println(s"Hello: $name") // 输出可以这样写


  //  多行string
  val b =
    """
      | 这是一个多行字符串
      | 赵浩任
      | 2019
    """.stripMargin
  print(b)

}
