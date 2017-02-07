/**
  * Created by lichao on 2017/2/7.
  */
object FunctionTest {
  def main(args: Array[String]): Unit = {
    //    println(decorate("hello"))
    //    println(decorate("hello", "<<", ">>"))
    //带名参数可以不完全和参数列表一致
    //println(decorate(left = "<<<", str = "hello", right = ">>>"))

    println(calculatePlus(2, 2));
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
}
