/**
 *
 */
package main.scala.MM

import main.scala.bprocesses.BProcess
import main.scala.simple_parts.context._

/**
 * Frame Link
 */

/**
 * CtxElems => Process
 */
class PrLink(start: Option[CtxElems], end: Option[BProcess]) {
  def from: Option[CtxElems] = this.start
  def to: Option[BProcess] = this.end
  PrLink.links = PrLink.links :+ this
}
object PrLink {
  var links: List[PrLink] = List()
  def relations = links.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)
}
object PrLinkDispatch {
  def apply(target: Any) = println(target.getClass)
  def to(target: Any) = {
    PrLink.links.find(_.to == Some(target))
  }
  def from(target: Any) = {
    println("dispatch invoked")
    PrLink.links.find(_.from == Some(target))
  }
}

/**
 * CtxElems => CtxElems
 */
/**
 * *
 * class CtxLink(start: Option[CtxElems], end: Option[CtxElems]) {
 * def from: Option[CtxElems] = this.start
 * def to: Option[CtxElems] = this.end
 * //PLink.links = PLink.links :+ this
 * }
 * object CtxLink {
 * var links: List[CtxLink] = List()
 * def relations = links.map(s ⇒ s.from.toString
 * + Console.RED + " -> " + Console.WHITE +
 * s.to.toString)
 * }
 * object CtxLinkDispatch {
 * def apply(target: Any) = println(target.getClass)
 * def to(target: Any) = {
 * val x = InvokeTracer.runner.get.arguments.toList.filter(_.from == Some(target))
 * x match {
 * //case None => None
 * case _ ⇒ x.map(_.to)
 * }
 * }
 * def from(target: Any) = {
 * InvokeTracer.runner.get.logger.log("dispatch invoked")
 * val x = InvokeTracer.runner.get.arguments.toList.find(_.to == Some(target))
 * // handle many argument
 * x match {
 * case None ⇒ None
 * case _    ⇒ x.get.from
 * }
 * }
 * }
 * *
 */
