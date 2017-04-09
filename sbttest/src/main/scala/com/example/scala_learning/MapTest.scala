package com.example.scala_learning

/**
  * Created by lichao on 2017/2/8.
  */
object MapTest {
  def main(args: Array[String]): Unit = {
    maps
  }

  def maps: Unit = {
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    val scores2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) //可变的映射

    val scores3 = new scala.collection.mutable.HashMap[String, Int]

    println(scores("Bob"))
  }
}
