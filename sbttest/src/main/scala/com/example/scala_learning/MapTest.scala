package com.example.scala_learning

/**
  * Created by lichao on 2017/2/8.
  */
object MapTest {
  def main(args: Array[String]): Unit = {
    // maps
    mapPattern
  }

  //map.get returns a vaule of type Option[T] which is either a value of type Some[T] or the value None:
  def mapPattern: Unit = {
    val myMap = Map("a" -> 42, "b" -> 43)
    def getMapValue(s: String): String = {
      myMap get s match {
        case Some(nb) => "Value found: " + nb
        case None => "No value found"
      }
    }

    //简单的写法
    def mapPattern2(s: String): String = myMap.get(s).map("Value found: " + _).getOrElse("No value found")

    println(getMapValue("a")) // "Value found: 42"
    println(getMapValue("c")) // "No value found"
  }


  def maps: Unit = {
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    val scores2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8) //可变的映射

    val scores3 = new scala.collection.mutable.HashMap[String, Int]

    println(scores("Bob"))
  }
}
