package com.example.scala_learning.module

/**
  * Scala 使用 extends 关键字来继承一个类。实例中 Location 类继承了 Point 类。Point 称为父类(基类)，Location 称为子类。
  * override val xc 为重写了父类的字段。
  * 继承会继承父类的所有属性和方法，Scala 只允许继承一个父类。
  *
  * @param xc
  * @param yc
  * @param zc
  */
class Location(override val xc: Int, override val yc: Int,
               val zc: Int) extends Point(xc, yc) {
  var z = zc;


  //Scala重写一个非抽象方法，必须用override修饰符。
  override def toString = "now location is: x: " + x + " y: " + y + " z: " + z;

  def move(dx: Int, dy: Int, dz: Int): Unit = {
    x = x + dx;
    y = y + dy;
    z = z + dz;
    println("now x: " + x);
    println("now y: " + y);
    println("now z: " + z);
  }
}
