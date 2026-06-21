
enablePlugins(SbtPlugin)
addSbtPlugin("com.github.sbt" % "sbt2-compat" % "0.1.0")

name := "sbt-github-packages"

version := "0.5.7-SNAPSHOT"
isSnapshot := {
  version.value.endsWith("-SNAPSHOT")
}
versionScheme := Some("semver-spec")

organization := "io.github.tayvs"
licenses := List(License.Apache2)

sbtPlugin := true

val scala212 = "2.12.19"
val scala3 = "3.8.4"

scalaVersion := scala3
crossScalaVersions := Seq(scala212, scala3)


(pluginCrossBuild / sbtVersion) := {
  scalaBinaryVersion.value match {
    case "2.12" => "1.9.9"
    case _      => "2.0.0"
  }
}
scriptedSbt := {
  scalaBinaryVersion.value match {
    case "2.12" => "1.9.9" // the tests are running on java 21
    case _      => "2.0.0"
  }
}

homepage := Some(url("https://github.com/tayvs/sbt-github-packages"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/tayvs/sbt-github-packages"),
    "scm:git@github.com:tayvs/sbt-github-packages.git"))

developers := List(
  Developer(id="tayvs", name="Sviat Stoliarenko", email="@tayvs", url=url("https://github.com/tayvs")))

pomIncludeRepository := { _ => false }
publishMavenStyle := true

publishTo := {
  val centralSnapshots = "https://central.sonatype.com/repository/maven-snapshots/"
  if (isSnapshot.value) Some("central-snapshots" at centralSnapshots)
  else localStaging.value
}

scriptedLaunchOpts ++= Seq("-Dplugin.version=" + version.value)
scriptedBufferLog := true
