package ch01

class V10_AssociatedObjClass {
  // 之所以要val 是因为scala需要区分 def 还是var 或者val
  private val username: String = "justin"
}

// 静态的- 之所以要object 因为scala 没有static概念，需要这个东西来模拟
object V10_AssociatedObjClass {
  def main(args: Array[String]): Unit = {
    // 伴生对象 编译后和伴生类是一个类，所以可以访问伴生类的属性
    println(new V10_AssociatedObjClass().username)

    // 单例模式使用apply后获取对象直接这样就可以获取了
    // 其本质为 Student.apply() 调用了伴生对象类获取单例的。
    val single = Singleton
    println(single)
  }
}


// 问题，单例模式，是要求我们有个静态的方法来获取到 该单例的实例的，那么scala没有static怎么做呢？
// 这时候需要 提供特殊的方法来实现该功能 ->apply 见下面伴生对象里面的。
class Singleton { // 伴生类
}

// 这个单例模式也算 伴生对象的作用之一，其他的还有比如 存放静态东西、创建对象等。
object Singleton { // 伴生对象
  def apply: Singleton = new Singleton()
}


// 写在类上的构造函数叫做主构造函数
class User(name: String /*构造函数参数*/) {
  // 方法体  就是构造函数的方法体
  println(name)
  println("这里是主构造函数")
  // 默认scala 也提供了无参数的构造函数

  // 我们还可以定义辅构造函数
  def this(name: String, age: Int) {
    this(name)
    println("这里是辅构造函数2")
  }
  // 这里注意一点： 函数的声明次序是有要求的，被使用的需要在使用者的前方。
  def this() {
    this("辅构造函数1", 10)
  }
}