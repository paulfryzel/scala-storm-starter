import AssemblyKeys._

seq(assemblySettings: _*)

name := "scala-storm-starter"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.9.1"

fork in run := true

resolvers ++= Seq(
  "twitter4j" at "http://twitter4j.org/maven2",
  "clojars.org" at "http://clojars.org/repo"
)

libraryDependencies ++= Seq(
  "org.clojure" % "clojure" % "1.2.0",
  "org.clojure" % "clojure-contrib" % "1.2.0",
  "org.twitter4j" % "twitter4j-core" % "2.2.5-SNAPSHOT",
  "org.twitter4j" % "twitter4j-stream" % "2.2.5-SNAPSHOT",
  "storm" % "storm" % "0.7.0" % "provided",
  "org.specs2" %% "specs2" % "1.8.2" % "test"
)

mainClass in Compile := Some("storm.starter.topology.ExclamationTopology")

mainClass in assembly := Some("storm.starter.topology.ExclamationTopology")

TaskKey[File]("generate-storm") <<= (baseDirectory, fullClasspath in Compile, mainClass in Compile) map { (base, cp, main) =>
  val template = """#!/bin/sh
java -classpath "%s" %s "$@"
"""
  val mainStr = main getOrElse error("No main class specified")
  val contents = template.format(cp.files.absString, mainStr)
  val out = base / "run-main-topology.sh"
  IO.write(out, contents)
  out.setExecutable(true)
  out
}
