package sbtghpackages

sealed trait TokenSource extends Product with Serializable {
  def ||(that: TokenSource): TokenSource =
    TokenSource.Or(this, that)
}

object TokenSource {
  final case class Environment(variable: String) extends TokenSource
  final case class GitConfig(key: String) extends TokenSource
  final case class Or(primary: TokenSource, secondary: TokenSource) extends TokenSource
}
