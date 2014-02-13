package main.scala.simple_parts.context
import main.scala.MM.Frame

/**
 * @author Sobolev
 *
 */
trait CtxElems {
  def invoke
  def fromReq(f: Frame)
  val isRequestable = false
}