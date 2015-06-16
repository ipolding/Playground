name := "json-combinators"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq {
  "com.typesafe.play" %% "play-json" % "2.3.4",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
}

