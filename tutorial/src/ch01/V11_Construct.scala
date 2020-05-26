package ch01

object V11_Construct {
  def main(args: Array[String]): Unit = {
    val c = new C1("justin")
  }
}


class P1(ps: String) {
  println("P1的构造方法" + ps)
}

// 当父类使用自定义的构造方法，我们子类必须要显示调用父类的构造方法。如下：
class C1() extends P1("ps") /*这里相当于调用了父类的构造方法*/ {
  println("C1的构造方法")

  def this(s: String) {
    this() // 这个必须放在第一行，不能放在后面
    println("C1的辅助构造方法")
  }
}

// 如果参数不想写死了
class C2(s: String) extends P1(s) /*将前面的s传到父类方法里面*/ {
  println("C1的构造方法")

  def this() {
    this("XXXX") // 这个调用的是 类上的构造方法。
    // 所以整个逻辑应该是： 外面调用这个this，这里this再调用类上的主构造，然后主构造将参数传递给父类构造。
    println("C1的辅助构造方法")
  }
}

// 类的构造方法的参数  作用域是整个类体中。 但是如果我们想要和java一样将参数 赋给成员变量，scala设计了更简单的写法：参数+var
// 外部就可以 p:P2 = new P2() p.name 直接在外部也能使用参数了。
class P2(var name:String){
  // var name = name 在java中构造函数的参数一般都赋值给了成员变量。 scala认为这种写法没有意义。
}