/**
 *
 *
 */

package main.scala.simple_parts.process
import main.scala.bprocesses.InvokeTracer
import main.scala.utils.links.LinkSearcher
import scala.util.Try
//import main.scala.bprocesses.links.ArgLinkDispatch

class Brick() extends ProcElems {

  override def toString = s"Brick:"
  def invoke {
    InvokeTracer.runner.get.logger.log("invoked brick")
  }
  //def linked_to = ArgLinkDispatch(this)
}

