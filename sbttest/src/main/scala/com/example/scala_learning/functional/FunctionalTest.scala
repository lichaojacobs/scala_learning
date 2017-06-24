package com.example.scala_learning.functional

import scala.math._

/**
  * Created by lichao on 2017/4/8.
  */
class FunctionalTest {

}

object TestMain {
  //函数后的_意味着你确实指的是这个函数，而不是碰巧忘记了给它送参数
  val fun = ceil _
  println(Array(3.14, 1, 42, 2.0).map(fun))

  //匿名函数
  val plusFun = (x: Double) => 3 * x

  //高阶函数
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

  //一些有用的高阶函数

  //快速产生0.1,0.2,...,0.9的集合方式
  val maps = (1 to 9).map(0.1 * _)

  //筛选出符合条件的
  val list = (1 to 9).filter(_ % 2 == 0)

  //reduceLeft接受一个二元函数_*_每一个下划线代表一个参数
  val list2 = (1 to 9).reduceLeft(_ * _)

  //二元函数排序
  val list3 = "mary has a little lamb".split(" ").sortWith(_.length < _.length);

  //闭包
  def mulBy(factor: Double) = (x: Double) => factor * x

  //factor 3保存入triple
  val triple = mulBy(3)
  //factor 0.5保存入half
  val half = mulBy(0.5)

  //求一个数的阶乘
  def factorial(n: Int): Int = {
    //Scala中的尾调用,Scala会监测到这种自递归，只要递归调用发生在尾部，编译器会优化成类似while循环的字节码
    //尾递归指的是调用者在一个递归调用之后不做其他事，只是返回这个调用的结果
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, acc * n)
    }

    go(n, 1)
  }

  //non tail 非尾递归
  def fib1(n: Int): Int = {
    def value(n: Int): Int = {
      if (n == 1) return 0;
      if (n == 2) return 1;

      value(n - 1) + value(n - 2)
    }

    value(n)
  }

  def main(args: Array[String]) {
    println(fib1(4))
  }

}
