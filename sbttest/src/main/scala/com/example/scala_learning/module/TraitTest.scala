package com.example.scala_learning.module

import scala.util.logging.Logged

/**
  * Created by lichao on 2017/4/7.
  * Scala特质相当于Java中的接口，但是可以同时有抽象的方法和具体的方法，这一点又与Java的接口不同。
  * Scala只能有一个超类，但是可以有多个特质
  */
trait Logger {
  def log(msg: String)
}

//带有具体实现的特质
trait ConsoleLogger {
  //具体的字段
  val maxLength = 15

  //抽象字段，当在具体类中使用该特质时，必须提供maxLength字段
  val minLength: Int

  def log(msg: String): Unit = println(msg)
}

//叠加在一起的日志 当叠加的特质过多，执行的顺序是从最后一个开始
trait TimeStampLogger extends Logged {
  override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg)
  }
}

//extends 而不是 implements 如果需要的特质不止一个，可以用with关键字来添加额外的特质
class TraitTest extends Logger with Cloneable with Serializable {
  override def log(msg: String): Unit = println(msg)
}

//带有特质的对象：在构造单个对象时，可以为对象添加特质
class SavingsAccount extends Logged {
  def withDraw(amount: Double): Unit = {
    if (amount > 10) log("Insufficient funds")
  }
}

object TestMain {
  def main(args: Array[String]): Unit = {
    //在构造对象的时候混入一个较好的日志特质,由于有字段是抽象的，所以使用的时候必须指定
    //    val acct = new SavingsAccount with ConsoleLogger {
    //      val minLength = 20
    //    }
  }
}
