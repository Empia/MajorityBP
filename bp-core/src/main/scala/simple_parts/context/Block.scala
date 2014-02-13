/**
 *
 *
 */
package main.scala.simple_parts.context

import main.scala.bprocesses.InvokeTracer
import main.scala.bprocesses.InvokeChecker
import scala.collection.mutable._
import main.scala.MM._
import main.scala.bprocesses.BProcess

class ProcInvoker extends CtxElems {

  override val isRequestable = true

  def fromReq(frame: Frame) = {
    lazy val proc: Option[BProcess] = frame.links.find(_.from == Some(this)).get.to
    if (InvokeChecker.isInputed(proc.get)) {
      InvokeTracer.run_proc(proc.get)
    } else { println("Error: input missed") }
  }

  def invoke = {

  }
}
