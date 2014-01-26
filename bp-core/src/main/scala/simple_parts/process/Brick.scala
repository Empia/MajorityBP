/**
 *
 *
 */

package main.scala.simple_parts.process
import main.scala.InvokeTracer
import main.scala.utils.ArgumentDispatch
import main.scala.utils.ParamDispatch

class Brick() extends ProcElems {

  override def toString = s"Brick:"
  def invoke {
    InvokeTracer.runner.get.logger.log("invoked brick")
  }
  def linked_to = BLinkDispatch(this)
}

class Result extends ProcElems with ArgumentDispatch { // with ArgumentDispatch
  lazy val obj = arguments
  def invoke() {
    InvokeTracer.runner.get.logger.log("Result:" + obj)
  }
  override def toString = s"Result $obj"
}

class Note(note: String) extends ProcElems {
  def invoke {
    println(s"boom $note")
  }
  override def toString = s"'$note'"
}

class Checker extends ProcElems with ArgumentDispatch with ParamDispatch {
  def invoke {
    println(s"call trait method...")
    this.arguments
    this.parameters

  }
}

