package ch01

package java {

  class Emp {

  }
  package util {

    class HashMap {

    }

    object V9_Package {
      def main(args: Array[String]): Unit = {
        val emp = new Emp() // 子包可以直接访问父包的内容，不需要去import
        val map = new java.util.HashMap()
        println(emp)
        println(map)
      }
    }

  }

}
