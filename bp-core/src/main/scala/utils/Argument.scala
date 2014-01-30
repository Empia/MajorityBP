package main.scala.utils
import main.scala.simple_parts.process._
/**
 *  Argument — Block transfer to object
 */
trait ArgumentDispatch { self ⇒
  // validate type of argument
  // handle many argument  
  def arguments = ArgLinkDispatch.from(this)
  def isArgsExist = self.arguments.isDefined

}