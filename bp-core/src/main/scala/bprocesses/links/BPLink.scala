/**
 *
 */
package main.scala.bprocesses.links
import main.scala.bprocesses.InvokeTracer
import main.scala.simple_parts.process.ProcElems

/**
 * Business Process Links
 */
class BPLink(start: Option[ProcElems], end: Option[ProcElems], nested: BProcess, multiple: Boolean = false) {
  def from: Option[ProcElems] = this.start
  def to: Option[ProcElems] = this.end
  //BPLink.links = BPLink.links :+ this
}

object BPLink extends BPLinkContainer[BPLink] {

}

object BPLinkSearcher extends LinkSearcher[BPLink] {

}

object BPLinkDispatch {
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
    } else if (BPLink.links.toList.filter(_.to == Some(target)).length == 1) {
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
