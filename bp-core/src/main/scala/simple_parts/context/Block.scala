/**
 *
 *
 */
package main.scala.simple_parts.context

import main.scala.bprocesses.InvokeTracer
import main.scala.bprocesses.InvokeChecker
import scala.collection.mutable._
import main.scala.simple_parts.process._
import main.scala.maps._
import main.scala.bprocesses.BProcess
import scala.collection.mutable._

class ProcInvoker extends CtxElems {

  override val isRequestable = true

  def fromReq(frame: Frame, input: ListBuffer[ProcElems] = ListBuffer.empty) = {
    lazy val proc: Option[BProcess] = frame.links.find(_.from == Some(this)).get.to

    // Fill input of process
    if (input != None) {
      println("##############")
      println(input)
      proc.get.fill(input)
    }

    if (InvokeChecker.isInputed(proc.get)) {
      InvokeTracer.run_proc(proc.get)
    } else { println("Error: input missed") }
  }

  def invoke = {

  }
}
