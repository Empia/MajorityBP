package main.scala.utils
import scala.collection.mutable._
import main.scala.simple_parts.process._
import main.scala.bprocesses.InvokeTracer

class Dimension(
  var container: ListBuffer[ProcElems] = ListBuffer())
    extends ProcElems {
  def pushit(target: ListBuffer[ProcElems]) {
    container = container ++ target
  }

  def push(f: ⇒ ListBuffer[ProcElems]) = {
    pushit(f)
  }

  def invoke = {
    pushit(ArgLinkDispatch.to(this).map(_.get).to[ListBuffer])
    InvokeTracer.run_dim(this, InvokeTracer.runner.get)
  }
}