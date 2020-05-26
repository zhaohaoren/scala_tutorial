package ch01

/**
  * java中的switch case 就相当于scala的模式配
  */
object V24_Switch {
  def main(args: Array[String]): Unit = {

    val op = '#'
    val n1 = 20
    val n2 = 10
    var res = 0


    // scala直接不允许 case穿透的情况，所以不需要break
    op match {
      case '+' => {
        res = n1 + n2
      }
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      //default，如果  不写这个，并且没有匹配上会抛出MatchError异常
      case _ => println("error op")
    }

    println(res)


    /**
      * Tips
      * _ 下滑线这个并不是一直都能用，而是看当前表达式能不能推断出来，如果能推断出来就可以用，如果推断有多个情况都能用_表示那么就不可以使用
      **/


    // 守卫
    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 当上面都不满足的时候，采用默认的时候可以根据条件 执行对应的地方。但是这个有顺序性，如果前面的匹配上了，那么后面的就不执行了。
        case _ if ch.toString.equals("3") => digit = 3
        // 如果这个移到前面去，那么就先执行这个，不会执行下面的。
        case _ => sign = 2
        case value => println(value) // case后面接变量，会将ch的值赋值给该变量。（没啥意义）
      }
      println(ch + " " + sign + " " + digit)
    }


    // 可以匹配类型
    val a = 2
    val obj = if (a == 1) 1 else if (a == 2) "2" else if (a == 3) Map("aa" -> 1)
    // 前提obj的类型也是不确定的，在一直变的
    val result = obj match {
      case a: Int => println(a + "is Int") // 只要是int类型的 都会被匹配
      case b: Map[Int, String] => println("is Map[Int,String]") // 这里面有个坑：泛型对于这个模式匹配是不起作用的,但是Array[String]起作用，因为Array对应class会编译成 String[] 这样的。他不是泛型
      case b: Map[String, Int] => println("is Map[String,Int]") // 下面同理
      case c: String => println("is String")
      case _ => println("啥也不是")
    }

    // 匹配类型和数据 数组匹配
    for (arr <- Array(Array(0), Array(0, 1), Array(0, 1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))) {
      val res = arr match {
        case Array(0) => "0" // 可以把一个数组进行匹配： 类型+数据 同时匹配
        case Array(x, y) => x + "=" + y // 两个值的数组匹配，同时赋值变量
        case Array(0, _*) => "以0开头的数组"
        case _ => "未匹配"
      }
      println("res=" + res)
    }
    //需要能看懂上面的另外一个写法,针对list的
    for (arr <- Array(List(0), List(0, 1), List(0, 1, 0), List(1, 1, 0), List(1, 1, 0, 1))) {
      val res = arr match {
        case 0 :: Nil => "0" // 可以把一个数组进行匹配： 类型+数据 同时匹配
        case x :: y :: Nil => x + "=" + y // 两个值的数组匹配，同时赋值变量
        case 0 :: tail => "以0开头的数组"
        case _ => "未匹配"
      }
      println("res=" + res)
    }
    // 还可以tuple匹配 略

    // 对象匹配
    object Square {
      // 反构造
      def unapply(arg: Double): Option[Double] = Some(math.sqrt(arg))

      // 构造
      def apply(z: Double): Double = z * z
    }
    val num: Double = 36.0
    // 模式匹配36是不是Square对象满足情况
    num match {
      case Square(n) => println(n) // print 为6  因为 num = Square(n) 所以要反向解析n ，计算n=6，n不为空，所以是匹配的。
      case _ => println("nothing matched")
    }


    // 模式匹配在变量申明中的用处
    val (x, y) = (1, 2)
    println(x + "=" + y)
    // / 和 % 的结果分别赋值给q 和 r
    val (q, r) = BigInt(10) /% 3
    println("q: " + q)
    println("r: " + r)


    //    for循环的模式匹配
    val list = List((1, 2), (2, 4), (2, 3))
    //    for (elem <- list) {
    //      println(elem._1 + "-" + elem._2)
    //    }
    for ((v1, v2) <- list) { //v1 v2 模式匹配tuple的_1 _2
      println(v1 + "-" + v2)
    }


    // 样例类，模板类
    /*
    * 样例类依然是一个类
    * 使用case关键字进行申明，是为了模式匹配优化的类
    * 参数默认都是val的，除非显式的申明他为var
    * 不需要new 就可以创建对象
    *
    * */
    abstract class Amount
    case class Dollar(value: Double) extends Amount
    case class Currency(value: Double, unit: String) extends Amount
    case object NoAmount extends Amount
    for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
      val res = amt match {
        case Dollar(v) => "$" + v
        case Currency(v, u) => v + " " + u
        case NoAmount => ""
      }
      println(amt + ":" + res)
    }

    // 密封类，上面的那个case可以放在代码任何地方，体验很差，所以密封类 让 case必须都放在一起
//    abstract sealed class MFClass


  }

}
