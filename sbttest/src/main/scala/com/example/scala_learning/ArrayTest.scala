package com.example.scala_learning

import scala.collection.mutable.ArrayBuffer

/**
  * Created by lichao on 2017/4/7.
  */
object ArrayTest {
  def main(args: Array[String]): Unit = {
    //    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo", "China" -> "Beijing")
    //    println(capitals get "France" getOrElse (""))
    //    val secret: Option[Any] = Option("hello")
    //    secret.foreach(s => println(s))
    testMap
  }

  class CC[T] {
    def unapply(a: Option[Any]): Option[T] = if (a.isEmpty) {
      None
    } else {
      Option(a.get.asInstanceOf[T])
    }
  }

  object M extends CC[Map[String, Any]]

  object S extends CC[String]

  def testIterator: Unit = {
    val list = Array("hello", "world", "goodbye")
    var index: Int = 0
    val lines =
      for {
        listElement <- list
        S(name) = Option(listElement)
      } yield {
        name + "end"
      }

    lines.foreach(println)
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
    b +=(1, 2, 3, 4, 5)

    //用 ++=操作符追加任何集合
    b ++= ArrayBuffer(6, 7, 8, 9, 10)

    //移除后5个元素
    b.trimEnd(5);

    //任意位置插入或移除元素
    b.insert(2, 6);
    b.insert(2, 7, 8, 9);

    b.remove(2)

    b.remove(2, 3) //第二个元素表示移除多少个元素

    //b.toArray //转成数组

    for (i <- 0 until b.length + 1) println(i)

    for (i <- b) println(i)

    for (i <- (0 until b.length).reverse) println(i) //逆序打印
  }


  def generateArray: Unit = {
    val b = ArrayBuffer[Int]()
    b +=(1, 2, 3, 4, 5)
    b ++= ArrayBuffer(6, 7, 8, 9, 10)

    //通常，当遍历一个集合时，若只想处理那些满足条件的元素，可以通过守卫：for 中的if来实现，在这里我们对每个偶数元素翻倍，生成新集合
    //原集合不受影响
    val newArray = for (i <- b if i % 2 != 0) yield i * 2

    for (i <- newArray) println(i)
  }


  def generateArrayInFP: Unit = {
    val b = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    //函数式编程实现过滤
    b.filter(_ % 2 == 0).map(2 * _)
    //或
    b.filter(_ % 2 == 0).map {
      2 * _
    }
  }

  //移除除第一个负数之外的所有负数 (有点问题)
  //  def removeNumber: Unit = {
  //    val b = ArrayBuffer(2, 34, 323, 1, -1, -5, 10, 99)
  //    var isFirst = true
  //    val indexArray = for (i <- 0 if isFirst || b(i) >= 0) yield {
  //      if (b(i) < 0) isFirst = false; i
  //    }
  //
  //    //将元素移动到前端，并截断尾端
  //    for (j <- 0 until b.length) b(j) = indexArray
  //    b.trimEnd(b.length - indexArray)
  //  }


  def commonMethods: Unit = {
    Array(1, 7, 2, 9).sum //对ArrayBuffer同样适用

    ArrayBuffer("Marray", "had", "a").max

    val b = ArrayBuffer(1, 7, 2, 9).sorted //一般的排序，原数组没有改变

    val bDescending = b.sortWith(_ > _) //降序排列

    val a = Array(1, 7, 2, 9)
    scala.util.Sorting.quickSort(a) //快速排序

    //mkString 指定元素之间的分隔符，另一个重载版本可以指定前缀后缀
    a.mkString(" and ")

    a.mkString("<", ",", ">")
  }


  def multiDimensionArray: Unit = {
    val matrix = Array.ofDim[Double](3, 4) //三行四列

    matrix(1)(1) = 42;

    //创建不规则二维数组
    val triangle = new Array[Array[Int]](10)
    for (i <- 0 until triangle.length)
      triangle(i) = new Array[Int](i + 1)

  }

  def testMap: Unit = {
    val names = List("peter", "paul", "mary")
    names.map(_.toUpperCase()).map(_ + " ").foreach(print)
    println()
    //第二种实现
    (for (n <- names) yield n.toUpperCase).map(_ + " ").foreach(print)
  }
}
