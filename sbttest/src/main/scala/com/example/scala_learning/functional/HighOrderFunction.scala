package com.example.scala_learning.functional

/**
  * Created by lichao on 2017/5/24.
  */
object HighOrderFunction {
  def main(args: Array[String]) {
    println(fun1(2))

    println(Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x))

    (1 to 9).map("*" * _).foreach(println _)

    //reduceLeft接受一个二元函数，并应用到序列的所有元素，从左到右
    (1 to 9).reduceLeft(_ * _)
    println("数组最大值: " + Array(1, 5, 4, 2, 9, 6).reduceLeft((x, y) => if (x > y) x else y))



    "mary has a little lamb".split(" ").sortWith(_.length < _.length)

    println(mulOneAtATime(6)(7))

    //foldLeft & foldRight
    Array(1, 2, 3).foldLeft(0)((sum, i) => sum + i)
    ((1 to 5)).foldRight(100)((i, sum) => sum - i)

    //foldLeft & foldRight简写
    (0 /: (1 to 100)) (_ + _)
    (1 to 100).foldLeft(0)(_ + _)

    //此写法是柯里化的结果
    //    var x = 5;
    //    until(x == 0) {
    //      x -= 1
    //      println(x)
    //    }

    println(largest(x => 10 * x - x * x, 1 to 10))
  }

  def fun1 = (x: Double) => 3 * x

  def mulBy(factor: Double) = (x: Double) => factor * x //返回 function

  //接受一个参数，生成另一个接受单个参数的函数(柯里化)
  def mulOneAtATime(x: Int) = (y: Int) => x * y

  // => 是 ()=>的缩写，无参函数
  def until(condition: => Boolean)(block: => Unit): Unit = {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  def largest(fun: Int => Int, inputs: Seq[Int]): Int = {
    inputs.map(fun).reduceLeft((x, y) => if (x > y) x else y)
  }
}
