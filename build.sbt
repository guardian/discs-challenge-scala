ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "discs"

lazy val root = (project in file("."))
  .settings(
    name := "discs",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
  )
