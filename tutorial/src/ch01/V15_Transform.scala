package ch01

object V15_Transform {
  def main(args: Array[String]): Unit = {
    // 隐式转换就是不需要显式强转的scala自动为我们转换
    // 1. 数值类型的自动转换属于隐式转换
    // 2. 多态的 父类和子类的转换也属于隐式转换
    // 我们还可以自定义转换规则：如下

    // 这个符合OCP 开闭原则，我们不需要改以前的代码，添加这个就能让以前的代码使用到该功能。
    // 函数名字随意，主要原理是编译为class的时候，scala为我们自动对下面的double数字调用了这个函数
    // 同种转换只能有一次
    implicit def transform(d: Double): Int = d.toInt

    //    val num: Int = 5.0 正常情况下，double类型的数据是无法转换为int的。如果想要自动的转换可以使用隐式转换。
    val num: Int = 5.0


    //region 类的隐式转换 添加丰富类的功能
    implicit def addFunc(mySql: Mysql15): Op15 = {
      new Op15()
    }

    var mysql = new Mysql15()
    mysql.select() // 不需要隐式转换
    mysql.delete() // 调用的是走了隐式转换的。这样就丰富了Mysql的功能而不需要修改Mysql的代码。--当然这个例子可能不太好
    //endregion


    // 还可以参数的隐式转换
    implicit val newName: String = "zhao" // 隐式值，scala是按照类型来判断的，所以只能有一个string这样的隐式值
    // 这个叫隐式参数
    def test(implicit name: String = "justin"): Unit = { // 这里使用的默认参数，但是后期我们需要变这个参数的时候 就修改代码了。可以通过implicit来动态修改默认参数
      println(name)
    }

    test() // 正常调用
    test // 隐式参数 可以不用写括号，这种在正常情况下，只有参数为空的情况下才可以的，但是隐式可以做到自动转换


    /**
      * 隐式类
      * 也是扩展类的功能
      * 特点：
      * 1. 构造参数有且只能有一个
      * 2. 隐式类 必须定义在包对象，半生类 类里面，也就是 隐式类不能定义在顶级
      * 3. 不是能是case class的
      * 4. 作用域内不能有与之名称相同的标识符
      */

    val user = new User15()
    user.insert()
    user.delete()

  }

  class User15 {
    def insert(): Unit = {

    }
  }

  // 这个转换的意思就是通过User来构造person 从而让user 哟delete方法。
  implicit class Person15(u: User15) {
    def delete(): Unit = {

    }
  }

}

// 隐式转换可以丰富类库的功能。 比如我们想给Mysql对象添加delete方法。
class Op15 {
  def delete(): Unit = {

  }
}

class Mysql15 {
  def select(): Unit = {

  }
}