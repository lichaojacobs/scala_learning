package com.example.scala_learning.coursera

/**
  * Created by lichao on 2017/5/21.
  */
object rationals {
  val x = new Rational(1, 2)
  x.number
  x.denom
}

class Rational(x: Int, y: Int) {
  def number = x;

  def denom = y;
}