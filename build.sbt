lazy val commonForAllBuildResouces = Seq{
  name := "knolkartTest"
  version := "0.1"
  scalaVersion := "2.12.4"
  libraryDependencies += "log4j" % "log4j" % "1.2.17"
}

lazy val root = (project in file("."))
  .aggregate(apiResources, inventory, account).dependsOn(apiResources,inventory,account)

lazy val apiResources = (project in file("apiResources"))
  .settings(
    commonForAllBuildResouces
  ).dependsOn(inventory)

lazy val inventory = (project in file("inventory"))
  .settings(
    commonForAllBuildResouces
  ).dependsOn(apiResources)

lazy val account = (project in file("account"))
  .settings(
    commonForAllBuildResouces
  )