package sbtghpackages

import sbt._

trait GitHubPackagesKeys {
  val githubOwner = settingKey[String]("The github user or organization name")
  val githubRepository = settingKey[String]("The github repository hosting this package")

  val githubTokenSource = settingKey[TokenSource]("Where to get the API token used in publication (defaults to github.token in the git config)")

  val githubSuppressPublicationWarning = settingKey[Boolean]("Whether or not to suppress the publication warning (default: false, meaning the warning will be printed)")

  val githubPublishTo = taskKey[Option[Resolver]]("publishTo setting for deploying artifacts to GitHub packages")
}

object GitHubPackagesKeys extends GitHubPackagesKeys
