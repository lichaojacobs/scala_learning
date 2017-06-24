package com.example.scala_learning

/**
  * Created by lichao on 2017/5/13.
  */
object ForTest {

  val DEFAULT_VALUE = "NOT_FOUND"

  def main(args: Array[String]): Unit = {
    val map = Map("wwid" -> "")
    println(map.get("wwid"))
  }

  def getWWid(record: Option[Any]): String = {
    record match {
      case x: Some[String] => if (x.get.isEmpty) DEFAULT_VALUE else x.get
      case None => DEFAULT_VALUE
    }
  }

  //for 循环的几种用法
  def forLoop(): Unit = {
    for (i <- 0 to 3; j <- 0 to 3 if i != j) {
      println(i * j);
    }

    val x = 10;
    val result = if (x > 0) 1 else 0;
    println(result);


    //yield
    var a = 0;
    val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // for 循环 (大括号用于保存变量和条件,循环中的 yield 会把当前的元素记下来，保存在集合中，循环结束后将返回该集合。)
    val retVal = for {a <- numList
                      if a != 3; if a < 8
    } yield a

    // 输出返回值
    for (a <- retVal) {
      println("Value of a: " + a);
    }



    for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")

    //可以加任意多的filter,不同的filter可以用分号隔开
    for (i <- 1 to 3; j <- 1 to 3 if i != j; if i % 2 == 0) print((10 * i + j) + " ")
    //for表达式中可以定义任意多的变量
    for (i <- 1 to 3; from = 4 - i; j <- from to 3) print((10 * i + j) + " ")

    //yield关键词开始的话，那么该循环会构造出一个集合，这被称为for推导式。推导式生成的集合与第一个generator是类型兼容的。
    for (c <- "hello"; i <- 0 to 1) yield (c + i).toChar
  }

  var factor = 3;
  val multiplier = (i: Int) => i * factor;
}
