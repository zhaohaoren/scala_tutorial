package src.oo

object SimpleObject {
  def main(args: Array[String]): Unit = {
    val people = new People()
    people.name = "justin"

    println(people.eat)
    people.printGender()

    val person = new Person("justin", 10)
    var student = new Student("king",20,"cs")

  }
}

class People {
  // 定义属性
  var name: String = _ // 占位符 val final的 不可用，使用占位符必须要把类型加上
  val age: Int = 10

  private[this] val gender = "male" // 暂时不知道这个this是干啥的

  def printGender() = {
    println(gender)
  }


  def eat(): String = {
    name + " eat..."
  }

  def watchFootball(teaming: String) = {
    println(name + "is watching " + teaming)
  }
}

// 带构造的类 类上的这个叫做主构造器
class Person(val name: String, val age: Int) {

  println("person constructor enter") // 不太清楚为啥能这么写

  val school = "ustc"
  var gender: String = _

  // 还可以定义一个附属构造器
  def this(name: String, age: Int, gender: String) {
    this(name,age) // 附属构造器的第一行必须是主构造器或者是其他的附属构造器
    this.gender = gender
  }

  println("person constructor leave")

}

//继承还是会创建父类再创建子类
class Student(name:String,age:Int,major:String) extends Person(name,age ){
  println("student enter")
  println("student leave")
}