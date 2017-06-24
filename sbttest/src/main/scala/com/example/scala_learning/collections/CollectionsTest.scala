package com.example.scala_learning.collections

import scala.collection.SortedSet

/**
  * Created by lichao on 2017/5/6.
  */
object CollectionsTest {
  //val fruitList = List("apples", "oranges", "pears")
  // Alternative syntax for lists
  val fruit = "apples" :: ("oranges" :: ("pears" :: Nil)) // parens optional, :: is right-associative
  fruit.head // "apples"
  fruit.tail
  // List("oranges", "pears")
  //  val empty = List()
  //  val empty = Nil

  val nums = Vector("louis", "frank", "hiromi")
  nums(1) // element at index 1, returns "frank", complexity O(log(n))
  nums.updated(2, "helena")
  // new vector with a different string at index 2, complexity O(log(n))

  val fruitSet = Set("apple", "banana", "pear", "banana")
  fruitSet.size
  // returns 3: there are no duplicates, only one banana

  val r: Range = 1 until 5
  // 1, 2, 3, 4
  //val s: Range = 1 to 5 // 1, 2, 3, 4, 5
  1 to 10 by 3 // 1, 4, 7, 10
  6 to 1 by -2
  // 6, 4, 2

  val s = (1 to 6).toSet
  s map (_ + 2)

  // adds 2 to each element of the set

  //  val s = "Hello World"
  //  s filter (c => c.isUpper)
  // returns "HW"; strings can be treated as Seq[Char]

  // Operations on sequences
  //  val xs = List(1, 2, 3)
  //  val ys = List(3, 4, 5)
  //  xs.length // number of elements, complexity O(n)
  //  xs.last // last element (exception if xs is empty), complexity O(n)
  //  xs.init // all elements of xs but the last (exception if xs is empty), complexity O(n)
  //  xs take n // first n elements of xs
  //  xs drop n // the rest of the collection after taking n elements
  //  xs(2) // the nth element of xs, complexity O(n)predicate
  //  xs ++ ys // concatenation, complexity O(n)
  //  xs.reverse // reverse the order, complexity O(n)
  //  xs updated(2, 5) // same list than xs, except at index n where it contains x, complexity O(n)
  //  xs indexOf 1 // the index of the first element equal to x (-1 otherwise)
  //  xs contains 1 // same as xs indexOf x >= 0
  //  xs filter empty // returns a list of the elements that satisfy the predicate p
  //  xs filterNot p // filter with negated p
  //  xs partition p // same as (xs filter p, xs filterNot p)
  //  xs takeWhile p // the longest prefix consisting of elements that satisfy p
  //  xs dropWhile p // the remainder of the list after any leading element satisfying p have been removed
  //  xs span p // same as (xs takeWhile p, xs dropWhile p)
  //
  //  List(x1,..., xn) reduceLeft op // (...(x1 op x2) op x3) op ...) op xn
  //    List(x1,..., xn).foldLeft(z)(op) // (...( z op x1) op x2) op ...) op xn
  //  List(x1,..., xn) reduceRight op // x1 op (... (x{n-1} op xn) ...)
  //    List(x1,..., xn).foldRight(z)(op) // x1 op (... (    xn op  z) ...)
  //
  //  xs exists p // true if there is at least one element for which predicate p is true
  //  xs forall p // true if p(x) is true for all elements
  //  xs zip ys // returns a list of pairs which groups elements with same index together
  //  xs unzip // opposite of zip: returns a pair of two lists
  //    xs.flatMap f // applies the function to all elements and concatenates the result
  //    xs.sum // sum of elements of the numeric collection
  //  xs.product // product of elements of the numeric collection
  //  xs.max // maximum of collection
  //  xs.min // minimum of collection
  //  xs.flatten // flattens a collection of collection into a single-level collection
  //  xs groupBy f // returns a map which points to a list of elements
  //  xs distinct // sequence of distinct entries (removes duplicates)
  //
  //  x +: xs // creates a new collection with leading element x
  //  xs :+ x
  // creates a new collection with trailing element x

  // Operations on maps
  //  val myMap = Map("I" -> 1, "V" -> 5, "X" -> 10) // create a map
  //  myMap("I") // => 1
  //  myMap("A") // => java.util.NoSuchElementException
  //  myMap get "A" // => None
  //  myMap get "I" // => Some(1)
  //  myMap.updated("V", 15)

  // returns a new map where "V" maps to 15 (entry is updated)
  // if the key ("V" here) does not exist, a new entry is added

  // Operations on Streams
  //val xs = Stream(1, 2, 3)
  //val xs = Stream.cons(1, Stream.cons(2, Stream.cons(3, Stream.empty))) // same as above
  //(1 to 1000).toStream // => Stream(1, ?)
  // x #:: xs // Same as Stream.cons(x, xs)
  // In the Stream's cons operator, the second parameter (the tail)
  // is defined as a "call by name" parameter.
  // Note that x::xs always produces a List


  //pairs
  def pairs: Unit = {
    val pair = ("answer", 42)
    // type: (String, Int)
    val (label, value) = pair // label = "answer", value = 42
    pair._1 // "answer"
    pair._2 // 42
  }


  //每个Scala集合特质或类都有一个带有apply方法的伴生对象，这个apply方法可以用来构建该集合中的实例。
  Iterable(0xFF, 0xFF00, 0xFF0000)
  Set(0xFF, 0xFF00, 0xFF0000)
  Map("1" -> 1, "2" -> 2)
  SortedSet("Hello", "World")


  //列表: Scala中，列表要么是Nil，要么是一个head元素加上一个tail,而tail又是一个列表
//  val digits = List(4, 2)
//  //::操作符从给定的头和尾创建一个新的列表
//  9 :: List(4, 2) //List(9,4,2)
//  9 :: 4 :: 2 :: Nil
//
//  digits.sum


  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

  def nth[T](index: Int, list: List[T]): T = {
    if (list.isEmpty || index < 0) throw new IndexOutOfBoundsException("index out of bound exception")
    if (index == 0) return list.head
    else nth(index - 1, list.tail)
  }

  def main(args: Array[String]): Unit = {
    println(singleton[Int](1).head)
  }
}
