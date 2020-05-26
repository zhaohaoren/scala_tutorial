package superfunction

// 匿名函数
object AnonyAPP extends App {

  // 匿名函数传给变量
  val f1 = (x: Int) => x + 1
  // 匿名函数传给方法
  def f2 = (x: Int) => x + 2

  println(f1(1))
  println(f2(2))


}
