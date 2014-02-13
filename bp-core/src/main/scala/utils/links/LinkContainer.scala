package main.scala.utils
import scala.collection.mutable._
import main.scala.bprocesses._
import main.scala.simple_parts.process._

trait LinkContainer {
  // BP Links
  // Ctx Links
}

trait BPLinkContainer extends LinkContainer {
  var arguments: ListBuffer[ArgLink] = ListBuffer()
  var params: ListBuffer[PLink] = ListBuffer()

  def arg_push(x: ArgLink) = arguments += x
  def param_push(x: PLink) = params += x

  def showArguments = arguments.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)
  def showParameters = params.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)
}

trait FrameLinkContainer[T] extends LinkContainer {
  var links: ListBuffer[T] = ListBuffer()

  def link_push(x: T) = links += x

  //def showLinks = links.map(s ⇒ s.from.toString
  //  + Console.RED + " -> " + Console.WHITE +
  //  s.to.toString)
}