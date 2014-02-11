/**
 *
 *
 */

package main.scala.simple_parts.process
import main.scala.bprocesses.InvokeTracer
import main.scala.utils.ArgumentDispatch
import main.scala.utils.ParamDispatch
import scala.util.Try

class Brick() extends ProcElems {

  override def toString = s"Brick:"
  def invoke {
    InvokeTracer.runner.get.logger.log("invoked brick")
  }
  def linked_to = ArgLinkDispatch(this)
}

