package com.example.scala_learning.module

/**
  * Created by lichao on 2017/4/6.
  * 单例对象：在 Scala 中，是没有 static 这个东西的，但是它也为我们提供了单例模式的实现方法，那就是使用关键字 object。
  * Scala 中使用单例模式时，除了定义的类之外，还要定义一个同名的 object 对象，它和类的区别是，object对象不能带参数。
  * 当单例对象与某个类共享同一个名称时，他被称作是这个类的伴生对象：companion object。
  * 你必须在同一个源文件里定义类和它的伴生对象。类被称为是这个单例对象的伴生类：companion class。类和它的伴生对象可以互相访问其私有成员。
  */
class Marker private(val color: String) {

}

// 伴生对象，与类共享名字，可以访问类的私有属性和方法
object Marker {
  private val markers: Map[String, Marker] = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

  //apply方法同样被经常用在伴生对象中，用来构造对象而不用显式地使用new
  def apply(color: String) = {
    if (markers.contains(color)) markers(color) else null
  }

  //unapply 与apply方法互为反向，unapply方法接受一个对象，然后从中提取值--通常这些值就是当初用来构造该对象的值
  def unapply(marker: Marker): Option[String] = if (marker != null) Option("true") else None

  //def unapply(arg: Marker): Option[] =

  def getMarker(color: String) = {
    if (markers.contains(color)) markers(color) else null
  }

  def main(args: Array[String]) {
    for ((k, v) <- markers) println("key is: " + k + "value is: " + v)
    println(Marker("red"))
    // 单例函数调用，省略了.(点)符号
    println(Marker getMarker "blue")
  }
}
