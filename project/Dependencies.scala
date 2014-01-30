import sbt._

object Dependencies {

  val resolutionRepos = Seq(
              "spray repo"  at "http://repo.spray.io/",
    "spray nightlies repo"  at "http://nightlies.spray.io"
  )

  val sprayVersion = "1.2.0"
  val akkaVersion  = "2.2.3"

  val slick           = "com.typesafe.slick"        %%  "slick"                 % "2.0.0"
  val slf4j           = "org.slf4j"                 %   "slf4j-nop"             % "1.6.4"
  //val json4s-n        = "org.json4s"                %%  "json4s-native"         % "3.2.6"
  //val json4s-j        = "org.json4s"                %%  "json4s-jackson"        % "3.2.6"
  val postgres        = "postgresql"                %   "postgresql"            % "9.1-901.jdbc4"

  val sprayJson       = "io.spray"                  %%  "spray-json"            % "1.2.5"
  val sprayJsonLenses = "net.virtual-void"          %%  "json-lenses"           % "0.5.3"
  val scalatest       = "org.scalatest"             %   "scalatest_2.10"        % "2.0"
  val logback         = "ch.qos.logback"            %   "logback-classic"       % "1.0.13"
  val snakeYaml       = "org.yaml"                  %   "snakeyaml"             % "1.13"
  val hdrHistogram    = "org.hdrhistogram"          %   "HdrHistogram"          % "1.0.8"
  val sprayCan        = "io.spray"                  %   "spray-can"             % sprayVersion
  val sprayRouting    = "io.spray"                  %   "spray-routing"         % sprayVersion
  val sprayTestkit    = "io.spray"                  %   "spray-testkit"         % sprayVersion
  val sprayClient     = "io.spray"                  %   "spray-client"          % sprayVersion
  val akkaActor       = "com.typesafe.akka"         %%  "akka-actor"            % akkaVersion
  val akkaSlf4j       = "com.typesafe.akka"         %%  "akka-slf4j"            % akkaVersion
  val akkaTestKit     = "com.typesafe.akka"         %%  "akka-testkit"          % akkaVersion
  val logbackClassic  = "ch.qos.logback" % "logback-classic" % "1.0.13"
  
  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")
  def runtime   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")
  def container (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")
}