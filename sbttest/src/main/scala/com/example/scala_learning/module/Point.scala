package com.example.scala_learning.module

import com.example.scala_learning.userEvent

/**
  * Created by lichao on 2017/4/6.
  * Scala中的类不声明为public，一个Scala源文件中可以有多个类。
  * 类参数在整个类中都可以访问。
  *
  * 构造器:
  * 对于Scala类，主构造器的参数放置在类名后，由括号括起来。
  * 且对于主构造器中var、val、private 等标注的参数，都会成为类的对应字段，并生成对应的默认getter、setter方法。
  */
class Point(val xc: Int, val yc: Int) {
  //声明变量时 变量的类型在变量名之后等号之前声明。定义变量的类型的语法格式如下：
  // var VariableName : DataType [=  Initial Value] 或 val VariableName : DataType [=  Initial Value]
  //变量声明不一定需要初始值，以下也是正确的：var myVar :Int; val myVal :String;
  //即 声明时不一定要指明变量类型，编译器自动可以推断出来
  var x: Int = xc;
  var y: Int = yc;

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx;
    y = y + dy;
    println("now x: " + x);
    println("now y: " + y);
  }
}

//在scala中没有静态方法和静态字段，所以在scala中可以用object来实现这些功能，直接用对象名调用的方法都是采用这种实现方式
object test {
  def main(args: Array[String]) {
    val point = new Point(0, 0);
    point.move(1, 2);

    var user = userEvent(12, "android", "andorid", "2.4", "china", "jiangxi", "jiangxi", "");
    val loc = new Location(10, 20, 15);
    loc.move(10, 10, 5);
  }
}

