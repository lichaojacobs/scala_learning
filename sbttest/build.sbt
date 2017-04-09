name := "sbttest"
version := "1.0"
scalaVersion := "2.10.4"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-streaming" % "1.6.0" % "provided",
  "org.apache.spark" %% "spark-streaming-kafka" % "1.6.0",
  "net.debasishg" %% "redisclient" % "3.0"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
