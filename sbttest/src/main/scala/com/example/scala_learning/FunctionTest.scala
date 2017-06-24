package com.example.scala_learning

/**
  * Created by lichao on 2017/2/7.
  */
object FunctionTest {
  def main(args: Array[String]): Unit = {
    //    println(decorate("hello"))
    //    println(decorate("hello", "<<", ">>"))
    //带名参数可以不完全和参数列表一致
    //println(decorate(left = "<<<", str = "hello", right = ">>>"))

    //println(calculatePlus(2, 2));

    //var list = Array(3, 2, 4, 9, 1, 5)
    //sort2(list).foreach(println)
    //list.foreach(println)

    //println(sqrt(2))

    //    println("Pascal's Triangle")
    //    for (row <- 0 to 10) {
    //      for (col <- 0 to row)
    //        print(pascal(col, row) + " ")
    //      println()
    //    }
    //    val list = List(2, 3, 4, 5, 6);
    //    list.dropRight(2)
    //    println(list.dropRight(1))
    //println(balance("()()()".toList))

    //println(countChange(15, List(5, 10, 25, 1)))

    //println(sum(x => x * x)(3, 5))

    //println(contains(x => true, -1))

    println(product(x => x * x)(3, 4))
  }

  //scala里的类型，除了在定义class,trait,object时会产生类型，还可以通过type关键字来声明类型。
  //simple type | functional type
  type Set = Int => Boolean

  // type X 是一个抽象类型，需要子类型在实现时提供X具体的类型。
  type T = Serializable {
    type X
    def foo(): Unit
  }


  def contains(s: Set, elem: Int): Boolean = s(elem)


  def listRecursive[T](list: List[T]): Unit = {
    def loop(tailList: List[T]): Int = {
      if (tailList.isEmpty) {
        0
      }
      else {
        println(tailList.head)
        loop(tailList.tail)
      }
    }
    loop(list)
  }

  def balance(chars: List[Char]): Boolean = {
    val openSymbol = '(';
    val closingSymbol = ')';
    def balanceLoop(openCount: Int, charList: List[Char]): Boolean = {
      if (charList.isEmpty && openCount == 0) return true
      if (openCount == 0 && !charList.isEmpty && charList.head.equals(closingSymbol)) return false
      if (openCount != 0 && charList.isEmpty) return false
      println(charList.head)
      println(openCount)
      if (charList.head.equals(openSymbol)) {
        return balanceLoop(openCount + 1, charList.tail)
      }
      if (charList.head.equals(closingSymbol)) {
        return balanceLoop(openCount - 1, charList.tail)
      }
      return balanceLoop(openCount, charList.tail)
    }

    balanceLoop(0, chars)
  }

  //零钱拼出指定钱的总方法数
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (coins.size == 0 || money < 0)
      0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }


  def quickSort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) xs
    else
      quickSort(xs.filter(x => x < xs.head)) ::: xs.head :: quickSort(xs.filter(x => x > xs.head))
  }

  def pascal(c: Int, r: Int): Int = factor(r) / (factor(c) * factor(r - c))

  def factor(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) 1 else loop(acc * n, n - 1)
    }

    loop(1, n);
  }


  //应该习惯没有return的日子,等号后面就是值
  def abs(x: Double) = if (x > 0) x else -x;

  def fac(n: Int) = {
    var r = 1
    for (i <- 1 to n) r = r * i
    r //返回值了
  }

  //对于递归函数，我们必须指定返回类型
  def fac2(n: Int): Int = if (n == 1) 1 else n * fac(n - 1);

  //函数默认值
  def decorate(str: String, left: String = "[", right: String = "]") = left + str + right

  //变长的参数,返回的类型是个Seq
  def sum(args: Int*) = {
    var result = 0;
    for (arg <- args) result = result + arg
    result
  }

  //Process 不含返回值，也没有等号
  def box(s: String): Unit = {
    val boder = "-" * s.length + "--\n"
    println(boder + "|" + s + "|\n" + boder)
  }

  def testFileUtil: Unit = {
    //在words 被首次使用时取值
    lazy val words = scala.io.Source.fromFile("/Users/lichao/desktop/gullet").mkString;
  }

  def calculatePlus(x: Int, n: Int): Int = {
    if (n == 0) x else x * calculatePlus(x, n - 1)
  }

  //函数参数的默认值
  def calculateSum(number1: Int = 0, number2: Int = 0) = number1 + number2;


  //apply和update方法 scala允许你将函数调用语法f(arg1,arg2,...)扩展到可以应用于函数之外的值
  //如果f不是函数或方法，那么这个表达式就等同于调用 f.apply(arg1,arg2,...)
  //除非它出现在赋值语句的等号左侧，表达式f(arg1,arg2,...)=value
  //对应调用为f.update(arg1,arg2,...,value)
  //这个机制被用于数组和映射
  def applyTest: Unit = {
    val scores = new scala.collection.mutable.HashMap[String, Int]
    scores("Bob") = 100 //调用scores.update("Bob",100)
    val bobsScore = scores("Bob") //调用socres.apply("Bob")

    println(bobsScore)
  }

  //不推荐的斐波那契的写法(存在可变的变量)
  def fib1(n: Int): Int = {
    var a = 0
    var b = 1
    var i = 0
    while (i < n) {
      val prev_a = a
      a = b
      b = prev_a + b
      i = i + 1
    }
    a
  }

  //函数式斐波那契
  def fib(n: Int): Int = {
    def fibIter(i: Int, a: Int, b: Int): Int =
      if (i == n) a else fibIter(i + 1, b, a + b)
    fibIter(0, 0, 1)
  }

  def sort(xs: Array[Int]) {
    def swap(i: Int, j: Int): Unit = {
      val t = xs(i);
      xs(i) = xs(j);
      xs(j) = t;
    }

    def quickSort(l: Int, r: Int): Unit = {
      val pivot = xs((l + r) / 2)
      var i = l;
      var j = r;
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) quickSort(1, j)
      if (j < r) quickSort(i, r)
    }

    quickSort(0, xs.length - 1)
  }

  def sqrt(x: Double) {
    def sort2(xs: Array[Int]): Array[Int] = {
      if (xs.length <= 1) xs
      else {
        val pivot = xs(xs.length / 2)
        Array.concat(
          sort2(xs filter (pivot >)),
          xs filter (pivot ==),
          sort2(xs filter (pivot <)))
      }
    }

    def sqrtIter(guess: Double, x: Double): Double = {
      if (isGoodEnough(guess, x)) guess else sqrtIter(improve(guess, x), x)
    }

    def isGoodEnough(guess: Double, x: Double): Boolean = {
      if (abs(guess * guess - x) / x < 0.001) true else false
    }

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    sqrtIter(1, x)
  }

  def sum(f: Int => Int)(a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

  def factorial(n: Int) = product(x => x)(1, n)

  //There is already a class in the standard library that represents orderings:
  // scala.math.Ordering[T] which contains comparison functions such as lt() and gt() for standard types.
  // Types with a single natural ordering should inherit from the trait scala.math.Ordered[T].
  def ordering: Unit = {
    val fruitList = List("apples", "oranges", "pears")

    def msort[T](xs: List[T])(implicit ord: Ordering[T]) = {
      fruitList.reverse
    }

    msort(fruitList)(Ordering.String.reverse)
    msort(fruitList) // the compiler figures out the right ordering
    println(fruitList)
  }
}
