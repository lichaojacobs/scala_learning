package com.example.scala_learning

/**
  * Created by lichao on 2017/5/6.
  */
object ForComprehensions {


  //a for-expression looks like a traditional for loop but works differently internally
  def forTest: Unit = {
    //for (x <- e1) yield e2 is translated to e1.map(x => e2)
    //for (x <- e1; y <- e2) yield e3 is translated to e1.flatMap(x => for (y <- e2) yield e3)
    //This means you can use a for-comprehension for your own type, as long as you define map, flatMap and filter.
    val pairs = for {
      i <- 1 until 10
      j <- 1 until i
      if j % 2 == 0
    } yield (i, j)

    //is equal to
    for (i <- 1 until 10; j <- 1 until i if j % 2 == 0)
      yield (i, j)

    // is equal to
    (1 until 10).flatMap(i => (1 until i).filter(j => j % 2 == 0).map(j => (i, j)))

    println(pairs)
  }


  def main(args: Array[String]) {
    //list all combinations of numbers x and y
    for (x <- 1 to 10; y <- 1 to 10) yield (x, y)
    // is equal to
    (1 to 10) flatMap (x => (1 to 10) map (y => (x, y)))

    //forTest
    println((1 to 10).flatMap(x => (1 to 10) map (y => (x, y))))
  }
}
