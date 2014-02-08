package main.scala.utils
import main.scala.simple_parts.process._
import scala.util.Try
/**
 *  Argument — Block transfer to object
 */
trait ArgumentDispatch { self ⇒
  // validate type of argument
  def arguments = ArgLinkDispatch.from(this)
  def isMultiple = Try(arguments.getClass.getMethod("head")).isSuccess
  //def isArgsExist = self.arguments.isDefined

  val isOptionalArg = false

}