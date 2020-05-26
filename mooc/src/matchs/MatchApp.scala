package src.matchs

object MatchApp extends App {

  judge("zhao", "A")

  def judge(name: String, grade: String) = {
    grade match {
      case "A" => println("Good")
      case "B" => println("Fine")
      case "C" => println("Bad")
      case _ if (name == "zhao") => println(name + "Wrong") //case 后面还可以加一层过滤
      case _ => println("Wrong")
    }
  }

  judge("zhao", "D")
  judge("chen", "D") // 并不会向下继续传递哦


  def arrayMatch(array: Array[String]): Unit = {
    array match {
      case Array("张三") => println("欢迎张三") // 如果数组是一个张三
      case Array(x, y) => println("hi", x, "and", y) // 如果数组是两个元素
      case Array("张三", _*) => println("hi 张三和其他的人") // 第一个是张三 后面多少个无所谓的数组
      case _ => println("others")
    }
  }

  arrayMatch(Array("张三", "李四")) // match有两个都匹配的 取第一个

  def listMatch(list: List[String]) = {
    list match {
      case "张三" :: Nil => println("Hi 张三") //表示为只有张三一个元素
      case x :: y :: Nil => println("Hi 两个元素") // 这就表示为两个元素
      case "张三" :: tail => println("张三开头后面尾巴无所谓" + tail) // 这个tail只是代指一个变量，可以换别的名字
      case _ => println("others")
    }
  }

  listMatch(List("张三", "李四", "王五"))

  def typeMatch(obj: Any): Unit = {
    obj match {
      case x: Int => println("int")
      case s: String => println("string")
      case m: Map[_, _] => println("map")
      case _ => println("other type")
    }
  }

  typeMatch(Map("name" -> "pk"))

  def caseclassMatch(person: Person): Unit = {
    person match {
      case CTO(name, floor) => println("CTO")
      case Emp(name, floor) => println("employee")
      case _ => println("others")
    }
  }

  caseclassMatch(CTO("wu", "1"))

}

class Person

case class CTO(name: String, floor: String) extends Person

case class Emp(name: String, floor: String) extends Person

case class Other(name: String) extends Person