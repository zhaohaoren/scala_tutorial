package ch01

/**
  * 泛型
  */
object V25_Generic {
  def main(args: Array[String]): Unit = {
    test[User](new User)

    // List<User> a = new ArrayList<User>() 类似
    val test2: Test[User] = new Test[User]


  }

  def test[T](t: T): Unit = {
    println(t)
  }

  // User的子类
  def test2[T <: User](t: T): Unit = {
    println(t)
  }

  // 和java 不一样，这种写法 = <T> 。。。 这个说法有待验证啊，视频也不知道讲的对不对。
  def test3[T >: User](t: T): Unit = {
    println(t)
  }

}

class Person {

}

class User extends Person {

}

class Child extends User {

}

class Test[User] {

}

// 协变 +  就是说User的子类 都可以接受
// val t:TestXie[User] = new TestXie[Child]
class TestXie[+User] {

}

// 逆变 - User的父类可以接受
// val t:TestNi[User] = new TestNi[Person]
class TestNi[-User] {

}