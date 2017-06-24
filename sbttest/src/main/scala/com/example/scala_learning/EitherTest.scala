package com.example.scala_learning

/**
  * Created by lichao on 2017/5/21.
  */
object EitherTest {

  //想要对错误包含更多信息，比如堆栈调用信息，以便在源码中定位错误。这种情况可以对Either的left 返回一个异常
  def safeDiv(x: Int, y: Int): Either[Exception, Int] =
    try Right(x / y)
    catch {
      case e: Exception => Left(e)
    }

  def main(args: Array[String]) {
    println(safeDiv(0, 1))
  }

}
