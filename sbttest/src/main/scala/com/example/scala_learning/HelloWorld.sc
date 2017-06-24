
"hello world"
Array(1, 2, 3, 4).sum
for (c <- "hello"; i <- 0 to 1) yield (c + i).toChar

val t1 = new NonEmpty(3, new Empty, new Empty) contains 3
println("weclome to scala" + t1)

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean
}

class Empty extends IntSet {
  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def contains(x: Int): Boolean = false
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def contains(x: Int): Boolean =
    if (elem < x) left contains (x)
    else if (elem > x) right contains (x)
    else true
}

Array("Mary", "had", "a", "little", "lamb");
val map = Map("lichao" -> 22, "wanglu" -> 23)

for ((k, v) <- map) println(k + v)

Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x)

(1 to 9).map(1 * _)

(1 to 9).map("*" * _).foreach(println _)

"mary has a little lamb".split(" ").sortWith(_.length < _.length)

