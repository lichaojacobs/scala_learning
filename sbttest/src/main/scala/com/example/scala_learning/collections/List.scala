package com.example.scala_learning.collections

/**
  * Created by lichao on 2017/5/30.
  */
trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

class Nil[T] extends List[T] {
  override def isEmpty = true

  def head = throw new NoSuchElementException("Nil.head");

  def tail = throw new NoSuchElementException("Nit.tail")
}

object List {
  //type bounds S<: T means:S is a subtype of T ,and S>: T means:S is a supertype of T
  // [S >: NonEmpty <: IntSet] S between NonEmpty and InsSet
  //object可以使list可以这样构造 List(1,2)=List.apply(1,2)
  def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1, new Cons[T](x2, new Nil[T]))

  def apply[T]: List[T] = new Nil[T]
}