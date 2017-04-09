package com.example.scala_learning

//选取器
import java.util.{HashMap => JavaHashMap}

import com.example.scala_learning.module.Marker

//隐式
import scala.collection.mutable._
import com.redis.RedisClient

/**
  * Created by lichao on 2017/4/6.
  */
object RedisUtil {
  lazy val conn: RedisClient = new RedisClient("ec2-54-159-208-93.compute-1.amazonaws.com", 6379)
}

object testMain {
  def main(args: Array[String]): Unit = {
    // println(Marker("red"))
    // 单例函数调用，省略了.(点)符号
    //println(Marker getMarker "blue")

    println(Marker.unapply(Marker("red")))
    //RedisUtil.conn.set("lichao", "22")

    //println(RedisUtil.conn.exists("lichao"))
  }
}
