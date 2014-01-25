resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Kamon Releases" at "http://repo.kamon.io"

resolvers += "sbt-taglist-releases" at "http://johanandren.github.com/releases/"

addSbtPlugin("com.typesafe.sbt" % "sbt-atmos" % "0.3.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.2.1")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.1")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.8")

addSbtPlugin("com.markatta" % "taglist-plugin" % "1.3")