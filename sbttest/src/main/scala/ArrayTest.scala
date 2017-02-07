/**
  * Created by lichao on 2017/2/8.
  * 本章要点：
  * 1、若长度固定则使用Array，若长度可能有变化则使用ArrayBuffer
  * 2、提供初始值时不要使用new
  * 3、用()来访问元素
  * 4、用for(elem<-arr)来遍历元素
  * 5、用for(elem<-arr if ...)...yield...来将原数组转型为新数组
  * 6、Scala数组和Java数组可以互操作；用ArrayBuffer,使用Scala.collection.JavaConversions中的转换函数
  */

import scala.collection.mutable.ArrayBuffer

object ArrayTest {
  def main(args: Array[String]): Unit = {

  }

  def someArray: Unit = {
    //10个整数的数组，所有元素初始化为0
    val nums = new Array[Int](10)
    //10个字符串数组，所有元素初始化为null
    val a = new Array[String](10)

    //长度为2的Array[String] 类型是推断出来的
    //说明：已提供初始值就不需要new
    val s = Array("Hello", "World")

    s(0) = "Goodbye" //访问元素用() 与Java不同
  }

  def testArrayBuffer: Unit = {
    //ArrayBuffer 对应Java中的ArrayList 变长数组
    val b = ArrayBuffer[Int]()
  }

}
