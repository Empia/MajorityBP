/**
 *
 *
 */
package main.scala.simple_parts.context

import main.scala.BProcess
import scala.collection.mutable._
import main.scala.MM._

class ProcInvoker extends CtxElems {
  import main.scala.InvokeTracer
  def invoke = {

    lazy val proc: Option[BProcess] = PrLink.links.find(_.from == Some(this)).get.to
    InvokeTracer.run_proc(proc.get)
  }
}
