/**
 *
 */
package main.scala.simple_parts.process
import main.scala.InvokeTracer
/**
 * Param Link
 */
class PLink(start: Option[ProcElems], end: Option[ProcElems]) {
  def from: Option[ProcElems] = this.start
  def to: Option[ProcElems] = this.end
  //PLink.links = PLink.links :+ this
}
object PLink {
  var links: List[PLink] = List()
  def relations = links.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)
}
object PLinkDispatch {
  def apply(target: Any) = println(target.getClass)
  def to(target: Any) = {
    val x = InvokeTracer.runner.get.arguments.toList.filter(_.from == Some(target))
    x match {
      //case None => None
      case _ ⇒ x.map(_.to)
    }
  }
  def from(target: Any) = {
    InvokeTracer.runner.get.logger.log("dispatch invoked")
    val x = InvokeTracer.runner.get.arguments.toList.find(_.to == Some(target))
    // handle many argument  
    x match {
      case None ⇒ None
      case _    ⇒ x.get.from
    }
  }
}
