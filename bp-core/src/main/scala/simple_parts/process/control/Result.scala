package main.scala.simple_parts.process.control
import main.scala.simple_parts.process.ProcElems
import main.scala.utils.ArgumentDispatch

class Result extends ProcElems with ArgumentDispatch { // with ArgumentDispatch
  lazy val obj = arguments

  def invoke() {
    if (isMultiple) {
      multiple(obj.productIterator.toList)
    } else {
      //!!!!!  InvokeTracer.runner.get.logger.log("Result:" + obj)
      println("result" + obj.toString)
    }
  }
  def plain() = println("result" + obj.toString);
  def multiple(obj: List[Any]) = {
    for (o ← obj) {
      // !!! InvokeTracer.runner.get.logger.log("Result:" + o)
      println("result" + o.toString)
    }
  }
  override def toString = s"Result $obj"
}