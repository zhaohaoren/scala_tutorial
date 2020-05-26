package ch01

/**
  * 打印字符串的三种方式
  */
object V2_StringPrint {

  def main(args: Array[String]): Unit = {
    val name = "justin"
    val age = 20
    // 1 字符串拼接
    println("this is " + name)
    // 2 格式化输出
    printf("this is %s\n", name)
    // 3 插值字符串（推荐）  s开头表示使用插值输出 ${} 使用EL表达式输出。
    println(s"this is ${name}")
    // 使用f 表示需要格式化输出
    println(f"this is $name, age is $age%.2f")
    // 使用raw 表示原始输出，对于里面的转义字符等 都会原样的输出。
    print(raw"this is $name, age is $age%.2f \n")
  }
}
