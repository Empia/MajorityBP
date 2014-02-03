/**
 *
 *
 */

package main.scala.simple_parts.process
import main.scala.InvokeTracer
import main.scala.utils.ArgumentDispatch
import main.scala.utils.ParamDispatch
import scala.util.Try

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

