package com.example.scala_learning.module

/**
  * Created by lichao on 2017/4/8.
  */
object Name {
  //可以用提取器从任何对象中提取信息
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}
