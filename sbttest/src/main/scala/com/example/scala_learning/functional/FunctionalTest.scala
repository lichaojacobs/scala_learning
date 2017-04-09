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

  def main(args: Array[String]) {
    println(list3)
  }

}
