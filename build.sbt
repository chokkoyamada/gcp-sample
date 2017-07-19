name := "jp.co.cyberss.live.cv"

version := "1.0"

scalaVersion := "2.12.2"

scalacOptions ++= Seq( "-deprecation", "-encoding", "UTF-8", "-target:jvm-1.8" )

libraryDependencies ++= Seq(
  "com.google.cloud" % "google-cloud-storage" % "1.2.1",
  "org.scalatest" %% "scalatest" % "3.0.1"
)
