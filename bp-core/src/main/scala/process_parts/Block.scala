/**
 *
 *
 */
package main.scala.process_parts

import scala.collection.mutable._
import main.scala.process_parts._
import main.scala.InvokeTracer

/**
 * @author Sobolev
 */
class Block(b_type: String, title: String, action: Any) extends ProcElems {

  override def toString = s"Block: $title"

  override def invoke {
    InvokeTracer.runner.get.logger.log("invoked block")
  }
}

class Constant[T](value: T) extends ProcElems {

  override def invoke {
    InvokeTracer.runner.get.logger.log("invoked const")
  }

  override def toString = s"Constant: $value"
}
class Stopper extends ProcElems {

  override def invoke {
    println("invoked stoper")
    val proc = main.scala.InvokeTracer.runner
    proc.get.stop(this)
  }
}

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
    pushit(BLinkDispatch.to(this).map(_.get).to[ListBuffer])
    InvokeTracer.run_dim(this, InvokeTracer.runner.get)
  }
}

class Condition(c: Boolean) extends ProcElems {
  lazy val d1 = {
    BLinkDispatch.to(this).head.get // FIX THAT!!!!!!!!!!!!!!!!!
    //new Dimension

  }
  lazy val d2 = {
    new Dimension // FIX THAT!!!!!!!!!!!!!!!!!
  }

  def invoke = {
    if (c) {
      d1.invoke
    } else {
      d2.invoke
    }
  }

}
//class Math {}

//class Loop {}
//class DataWork {}
// *  Data set
// *  Data get
// *  Data filter
//class Sender {}
