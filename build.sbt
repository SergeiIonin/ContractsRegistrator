import sbt.Keys.{dependencyOverrides, libraryDependencies}
import sbt.Resolver

lazy val commonSettings = Seq(
  organization := "io.github.sergeiionin",
  scalaVersion := "3.4.2",
  version := "0.1.0-SNAPSHOT",
  autoCompilerPlugins := true,
  idePackagePrefix := Some("io.github.sergeiionin.contractsregistrator"),
  resolvers ++= res,
  libraryDependencies ++=
    Dependencies.catsDependencies ++
      Dependencies.circeDependencies ++
      Dependencies.tapirDependencies ++
      Dependencies.http4s ++
      Dependencies.fs2 ++
      Dependencies.grpc ++
      Dependencies.schemaRegistry ++
      Dependencies.miscDependencies ++
      Dependencies.testDependencies ++
      //Dependencies.kafka ++
      Dependencies.miscDependencies :+
      "org.scala-lang.modules" %% "scala-collection-compat" % "2.12.0",
  dependencyOverrides += "org.scala-lang.modules" %% "scala-collection-compat" % "2.12.0"
)

lazy val common = (project in file("common"))
  .settings(commonSettings)
  .settings(
    name := "common",
  )

lazy val reader = (project in file("reader"))
  .settings(commonSettings)
  .settings(
    name := "reader",
  )
  .dependsOn(common)

lazy val restApi = (project in file("rest-api"))
  .settings(commonSettings)
  .settings(
    name := "rest-api",
  )
  .dependsOn(common)

lazy val proto = project
  .settings(commonSettings)
  .settings(
    name := "proto",
  )
  .settings(
    libraryDependencies ++= {
      Seq(
        "com.google.protobuf" % "protobuf-java" % "4.27.2" % "protobuf",
        "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
      )
    })
  .enablePlugins(Fs2Grpc)

val res = Seq(
  "Confluent"                 at "https://packages.confluent.io/maven/",
  "Sonatype releases"         at "https://oss.sonatype.org/content/repositories/releases",
  "Maven Central"             at "https://repo1.maven.org/maven2",
)
