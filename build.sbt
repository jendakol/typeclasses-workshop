lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "cz.jenda.workshop.typeclasses",
      scalaVersion := "2.13.0"
    )),
    name := "typeclasses-workshop"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
