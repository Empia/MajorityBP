/**
 *
 *
 */

package main.scala.simple_parts.process
import main.scala.bprocesses.BProcess
import main.scala.bprocesses.InvokeTracer
import main.scala.utils.links.LinkSearcher
import scala.util.Try

class Brick(proc: BProcess, order: Int) extends ProcElems {

  override def toString = s"Brick:"
  def invoke {
    println("invoked brick")
  }
  def getSpace = {
    proc.getSpaceByOrder(order).head
  }
  def getSpaces = {
    proc.getSpaceByOrder(order)
  }
  

}

