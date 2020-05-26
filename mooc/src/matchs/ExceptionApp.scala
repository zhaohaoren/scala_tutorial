package src.matchs

object ExceptionApp extends App {

  try {
    val i = 10 / 0
    println(i)
  } catch {
    case e: ArithmeticException => println("计算异常")
    case e: Exception => println(e.getMessage)
  } finally {

  }

}
