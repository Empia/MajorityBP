package main.scala.simple_parts.context
import main.scala.maps.Frame
import scala.collection.mutable._
import main.scala.simple_parts.process._

/**
 * @author Sobolev
 *
 */
trait CtxElems {
  def invoke
  def fromReq(f: Frame, input: ListBuffer[ProcElems] = ListBuffer.empty)
  val isRequestable = false
}