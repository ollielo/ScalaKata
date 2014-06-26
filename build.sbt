name := "Scala Kata"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.0" % "test"

resolvers ++= Seq(
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test"
)


