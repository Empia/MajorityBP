/**
 *
 */
package main.scala.simple_parts.process
import main.scala.InvokeTracer

/**
 * Arg Link
 */
class ArgLink(start: Option[ProcElems], end: Option[ProcElems]) {
  def from: Option[ProcElems] = this.start
  def to: Option[ProcElems] = this.end
  //ArgLink.links = ArgLink.links :+ this
}

object ArgLink {
  var links: List[ArgLink] = List()
  def relations = links.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)
}

object ArgLinkDispatch {
  def proc = InvokeTracer.runner.get
  def apply(target: Any) = println(target.getClass)
  def to(target: Any) = {
    val x = proc.arguments.toList.filter(_.from == Some(target))
    x match {
      //case None => None
      case _ ⇒ x.map(_.to)
    }
  }
  def isMultiple(target: Any) = {
    if (proc.arguments.toList.filter(_.to == Some(target)).length > 1) {
      proc.arguments.toList.filter(_.to == Some(target)).map(_.from)
    } else if (ArgLink.links.toList.filter(_.to == Some(target)).length == 1) {
      proc.arguments.toList.filter(_.to == Some(target)).head.from
    } else {
      None
    }
  }
  def from(target: Any) = {
    InvokeTracer.runner.get.logger.log("dispatch invoked")
    isMultiple(target)
  }
}
