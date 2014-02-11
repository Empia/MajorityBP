package main.scala.simple_parts.process.data
import main.scala.simple_parts.process.ProcElems
import main.scala.bprocesses.InvokeTracer

class Constant[T](value: T) extends ProcElems {

  override def invoke {
    InvokeTracer.runner.get.logger.log("invoked const")
  }

  override def toString = s"Constant $value"
}
