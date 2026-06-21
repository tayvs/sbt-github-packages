import scala.sys.process._

val ArtifactId = "sbt-github-packages-tests-publish"

ThisBuild / organization := "io.github.tayvs"
ThisBuild / version := s"${sys.props("plugin.version")}"

ThisBuild / githubOwner := "tayvs"
ThisBuild / githubRepository := "sbt-github-packages"
ThisBuild / githubTokenSource := TokenSource.Environment("GITHUB_TOKEN")

lazy val root = project.in(file("."))

lazy val publisher = project
  .in(file("publisher"))
  .settings(name := ArtifactId)

lazy val resolver = project
  .in(file("resolver"))
  .settings(
    libraryDependencies += "io.github.tayvs" %% ArtifactId % version.value)
