name := """streaming-database"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  filters,
  ws,

  "com.typesafe.play" %% "play-slick" % "2.0.0" % Compile,
  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.0" % Compile,
  "mysql" % "mysql-connector-java" % "5.1.40" % Compile,

  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

