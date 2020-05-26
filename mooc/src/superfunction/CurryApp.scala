package superfunction

object CurryApp extends App {

  def sum(n1: Int, n2: Int) = n1 + n2

  println(sum(1, 2))


  //curry就是可以将参数拆开来写
  def sum2(n1: Int)(n2: Int) = n1 + n2

  println(sum2(1)(2))
}
