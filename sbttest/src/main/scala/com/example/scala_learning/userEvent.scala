package com.example.scala_learning

/**
  * Created by lichao on 2017/4/7.
  */
//样例类
//某个类一旦被定义为case class，则编译器会自动生成该类的伴生对象，伴生对象中包括了apply方法及unapply方法，
// apply方法使得我们可以不需要new关键字就可以创建对象，而unapply方法，则使得可以方便地应用在模式匹配当中，
// 另外编译器还自动地帮我们实现对应的toString、equals、copy等方法。
// 在实际中，case class除了在模式匹配时能发挥其强大的威力之外，在进行其它应用时，也显示出了其强大的功能，
case class userEvent(timestamp: Long,
                     watch_device_id: String,
                     watch_device_type: String,
                     ticwear_version: String,
                     nation: String,
                     province: String,
                     city: String,
                     event: String)

object Name {
  //可以用提取器从任何对象中提取信息
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}

//可以用它从字符串中提取数字
object Number {
  def unapply(arg: String) = {
    try {
      Some(Integer.parseInt(arg))
    } catch {
      case ex: NumberFormatException => None
    }
  }
}

//提取器也可以只是测试其输入而不是将值提取出来。这样方法返回Boolean
object isCompound {
  def unapply(arg: String) = arg.contains("lichao")
}

