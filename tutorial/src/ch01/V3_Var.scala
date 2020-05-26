package ch01

/**
  * scala 变量
  * -
  * 和 java 区别
  * 1、scala申明变量必须显式的初始化变量
  * 2、val 表示final变量
  * 3、没有基本数据类型，一切都是对象。Scala 与 Java有着相同的数据类型，在Scala中数据类型都是对象，也就是说scala没有java中的原生(基本)类型
  * 4、Scala数据类型分为两大类 AnyVal(值类型) 和 AnyRef(引用类型)， 注意：不管是AnyVal还是AnyRef 都是对象。
  */
object V3_Var {

  def main(args: Array[String]): Unit = {

    // 最标准的申明变量方式
    var name: String = "justin"
    // scala有自动类型推断，可以简写为var name= "justin"
    var age: Int = 10
    //    10.toString  scala 一切都是对象 这个10 其实也是一个对象，可以使用方法的，scala会自动将其转为对象
    var c: Char = 'C'



    //    name = 1 scala 依然是一个强类型语言，变量的类型是不能改的
    name = "zhao"

    var flag = true
    val unit = if (flag){
      "true"
    }

    /*
        // val 申明变量不可以修改值
        val finalName = "justin"
        finalName = "zhao"
    */

    /*
        // 申明必须初始化
        var name:String
        name = "justin"
    */


    // null 其实就是一个Null类的一个实例
    val s: String = null
    //    val i: Int = null  这个是错误的：null 是引用的 类树上 Ref 和 Val 是不可以互相转换的，上面String是Ref


  }

  def func1(): Nothing = {
    throw new Exception()
  }

}
