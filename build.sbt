name := """stockproblems2"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "com.github.nscala-time" %% "nscala-time" % "2.2.0",
  "com.softwaremill.macwire" %% "macros" % "1.0.7",
  "com.softwaremill.macwire" %% "runtime" % "1.0.7",
  "org.mockito" % "mockito-all" % "1.8.4" % "test"
)

