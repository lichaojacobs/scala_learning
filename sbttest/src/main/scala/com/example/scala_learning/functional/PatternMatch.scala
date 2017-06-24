package com.example.scala_learning.functional

import scala.collection.immutable.Stream.cons

/**
  * Created by lichao on 2017/5/1.
  */
object PatternMatch {

  //::符号，读作Cons，是将一个新元素组合到已有元素的最前端，然后返回结果List。
  val x = List(1, 2, 3, 4, 5) match {
    case x :: 2 :: 4 :: _ => x
    case Nil => 42
    //case _ :: t => t
    case x :: y :: 3 :: 4 :: _ => x + y
    case h :: t => h
    case _ => 101
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0;
    //递归调用
    case x :: xs => x + sum(xs)
  }

  def products(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case x :: xs => x * products(xs)
  }

  //参数列表的形式
  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
    case h :: t if f(h) => dropWhile(t)(f)
    case _ => as
  }

  def Cons[A](x: A, y: List[A]): List[A] = {
    x :: y
  }

  //综合sum 和 products
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case x :: xs => f(x, foldRight(xs, z)(f))
  }

  //  def scanRight[B](z: B)(f: (A, => B) => B): Stream[B] =
  //    foldRight(Stream(z))((c, r) => cons(f(c, r.headOption.get), r))
  //
  //  def scanRight2[B](z: B)(f: (A, => B) => B): Stream[B] =
  //    foldRight((z, Stream(z)))((a, p0) => {
  //      lazy val p1 = p0
  //      val b2 = f(a, p1._1)
  //      (b2, cons(b2, p1._2))
  //    })._2
  //
  //  def scanRight3[B](z: B)(f: (A, => B) => B): Stream[B] =
  //    foldRight(Stream(z)) {
  //      case (a: A, t@Cons(h: B, _)) => cons(f(a, h), t)
  //    }

  //option，有效的输出被封装成some,无效的被映射成None
  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)


  //
  //  def foleLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
  //    case Nil => Nil;
  //  }

  //序列的head是参数args的首个元素，
  // 而tail是所有其它的元素序列，这是个Seq，需要用 _*将它转为参数序列。
  def sum2(args: Int*): Int = {
    if (args.length == 0)
      0
    else
      args.head + sum2(args.tail: _*)
  }

  def length[A](as: List[A]): Int = {
    as.length;
  }

  def pairsPattern = {
    val pairs: List[(Char, Int)] = ('a', 2) ::('b', 3) :: Nil
    val chars: List[Char] = pairs.map(p => p match {
      case (ch, num) => ch
    })

    println(chars)
  }

  def pl(a: String, b: Int): String = {
    println(a + ":" + b);
    a + b
  }

  def regPattern = {
    val pattern = "([0-9]+) ([a-z]+)".r
    //unapply或unapplySeq方法 正则表达式子用来提取每个分组的结果
    "99 bottles" match {
      case pattern(num, item) => print(s"have $num count for $item")
    }
  }


  //样例类是一种特殊的类，他们经过优化以被用于模式匹配。
  //样例对象的几个特点：
  // 1. 提供apply方法不用new关键字就能构造相应的对象. 2. 提供unapply方法让模式匹配可以工作
  abstract class Amount

  case class Dollar(value: Double) extends Amount

  case class Currency(vallue: Double, unit: String) extends Amount

  //针对单例的样例对象
  case object Nothing extends Amount

//  def testCase = {
//    val amt = Nothing
//    amt match {
//      case Dollar(v) => "$" + v
//      case Currency(_, u) => "oh nose , i got " + u
//      case Nothing => "nothing"
//    }
//  }


  def main(args: Array[String]) {
    //List(1, 2, 3, 4, 5).foldLeft("0")(pl(_, _))

    //字符串拼接
    //    val prefix = "test"
    //    val name = "key"
    //    val key = s"${prefix}_$name"
    //    println(key)

    //list.dropWhile(x => x < 2)
    //println(Cons(0, list))
    //println(x)
    //println(dropWhile(list)(x => x < 4))
    //println(sum(list))

    //println(foldRight(list, 0)((x, y) => x + y))
    regPattern
  }
}
