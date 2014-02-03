/**
 *
 */

package main.scala.MM_parts
//import main.scala.InvokeTracer
/**
 * @author Sobolev
 *
 */
/**
 * ****
 * class MLink(start: Option[ProcElems], end: Option[ProcElems]) {
 * def from: Option[ProcElems] = this.start
 * def to: Option[ProcElems] = this.end
 * MLink.links = MLink.links :+ this
 * }
 *
 * object MLink {
 * var links: List[MLink] = List()
 * def relations = links.map(s ⇒ s.from.toString
 * + Console.RED + " -> " + Console.WHITE +
 * s.to.toString)
 * }
 *
 * object MLinkDispatch {
 * def apply(target: Any) = println(target.getClass)
 * def to(target: Any) = {
 * val x = MLink.links.toList.filter(_.from == Some(target))
 * x match {
 * //case None => None
 * case _ ⇒ x.map(_.to)
 * }
 * }
 * def from(target: Any) = {
 * MInvokeTracer.runner.get.logger.log("dispatch invoked")
 * val x = MLink.links.toList.find(_.to == Some(target))
 * x match {
 * case None ⇒ None
 * case _    ⇒ x.get.from
 * }
 * }
 * }
 */ //////