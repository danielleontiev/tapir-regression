name := "tapir-regression"

version := "0.1"

scalaVersion := "2.13.5"

lazy val tapir = "0.18.0-M7"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.tapir" %% "tapir-core"               % tapir,
  "com.softwaremill.sttp.tapir" %% "tapir-json-circe"         % tapir,
  "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs"       % tapir,
  "com.softwaremill.sttp.tapir" %% "tapir-openapi-circe-yaml" % tapir,
)
