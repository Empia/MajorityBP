package main.scala.utils
import main.scala.simple_parts.process._
import scala.util.Try
/**
 *  Argument — Block transfer to object
 */
trait ArgumentDispatch { self ⇒
  // validate type of argument
  // handle many argument  
  def arguments = ArgLinkDispatch.from(this)
  //def isArgsExist = self.arguments.isDefined
  def isMultiple = Try(arguments.getClass.getMethod("head")).isSuccess
}