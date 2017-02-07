/**
  * Created by lichao on 2017/2/7.
  */
object Test {
  def main(args: Array[String]): Unit = {
    delayed(time());
  }

  def printSomething(a: Int, b: Int): Unit = {
    val (myVar1: Int, myVar2: String) = Pair(40, "Foo")
    println("hello world, value is : " + (myVar1 + myVar2))
  }


  def time() = {
    println("获取时间，单位为纳秒")
    System.nanoTime;
  }

  def delayed(t: => Long) = {
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }

  def forLoop(): Unit = {
    for (i <- 0 to 3; j <- 0 to 3 if i != j) {
      println(i * j);
    }

    val x = 10;
    val result = if (x > 0) 1 else 0;
    println(result);


    //yield
    var a = 0;
    val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // for 循环 (大括号用于保存变量和条件,循环中的 yield 会把当前的元素记下来，保存在集合中，循环结束后将返回该集合。)
    val retVal = for {a <- numList
                      if a != 3; if a < 8
    } yield a

    // 输出返回值
    for (a <- retVal) {
      println("Value of a: " + a);
    }
  }

  var factor = 3;
  val multiplier = (i: Int) => i * factor;
}
