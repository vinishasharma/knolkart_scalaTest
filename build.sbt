lazy val commonForAllBuildResouces = Seq{
  name := "knolkartTest"
  version := "0.1"
  scalaVersion := "2.12.4"
  libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17","org.scalatest"%"scalatest_2.12"%"3.0.4"%"test")
}

lazy val apiResources = (project in file("apiResources"))
  .settings(
    commonForAllBuildResouces
  ).dependsOn(inventory,account,checkout)

lazy val inventory = (project in file("inventory"))
  .settings(
    commonForAllBuildResouces
  )

lazy val account = (project in file("account"))
  .settings(
    commonForAllBuildResouces
  )
lazy val checkout = (project in file("checkout"))
  .settings(
    commonForAllBuildResouces
  ).dependsOn(inventory)
lazy val dashboard = (project in file("dashboard"))
  .settings(
    commonForAllBuildResouces
  ).dependsOn(apiResources)

