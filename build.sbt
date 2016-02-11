name := "lvat"

version := "0.5-SNAPSHOT"

organization := "ca.uwaterloo.gsd"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
    "org.scala-lang.modules" % "scala-swing_2.11" % "2.0.0-M2",
    "com.novocode" % "junit-interface" % "0.11" % "test",
    "junit" % "junit" % "4.12",
    "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    "com.google.protobuf" % "protobuf-java" % "2.6.1",
    "com.googlecode.kiama" % "kiama_2.11" % "1.8.0"
)

resolvers += "Local Maven Repository" at Path.userHome.asURL + "/.m2/repository"

// only show 10 lines of stack traces
traceLevel := 10

javaOptions += "-Xss8192k -Xmx2048m"

scalacOptions := Seq("-deprecation", "-unchecked")

// workaround for "Scaladoc generation failed" on BuilderParent for Protobuf
publishArtifact in (Compile, packageDoc) := false 



// FIXME Merge strategy for assembly
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case x => MergeStrategy.first
    // case x => old(x)
  }
}
