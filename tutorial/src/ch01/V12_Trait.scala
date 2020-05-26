package ch01

object V12_Trait {
  def main(args: Array[String]): Unit = {
    //    new D3()

    val mysql = new MySql()
    mysql.insert()
  }
}

// 申明特质，类似于接口，但是 他走的是继承。
class P3 {

}

trait P4 {

}

trait P5 {

}

// 继承特质 -- 实现多继承，可以继承多个特质。 使用with连接。
// 如果有继承父类的，那么extends后面+父类，with后面加特质
class C4 extends P3 with P4 with P5 {

}


trait M1 {
  println("M1 is trait")
}

class D2 extends M1 {
  println("D2 is class")
}

class D3 extends D2 with M1 {
  println("D3 is class")
}

//  new D3() 结果：
// M1 is trait
// D2 is class
// D3 is class
// 原因解析： D3 先去构造父类，然后父类又要去实现M1  所以先print M1 然后调用父类构造print D2。最后实现自己的构造
// D3 也实现了M1 但是M1 只要被初始化了就不会再构造了


trait Op {
  println("Op init")

  def insert(): Unit = {
    println("插入数据")
  }
}

trait DB extends Op {
  println("DB init")

  // 继承特质覆盖方法 需要加上override 和java一样。
  override def insert(): Unit = {
    println("向数据库")
    super.insert()
  }
}

trait File extends Op {
  println("File init")

  override def insert(): Unit = {
    println("向文件中")
    super.insert()
//    super[Op].insert();  如果就想要调用父级的方法，需要使用该特殊语法： super[特质].function 来指定特质进行调用
  }
}

class MySql extends DB with File {
  // 执行结果   val mysql = new MySql(); mysql.insert()
  /*
    Op init
    DB init  构建对象的时候 继承多个特质的话，从左到右一次实现特质
    File init
    向文件中  当调用特质的方法的时候 从右边到左边 执行特质的方法。
    向数据库  super不是调用的父类的方法，而是调用上一个特质的方法。 所以 先调用File的insert 然后super.insert调用DB的特质，然后调用Op的
    插入数据
    */
}