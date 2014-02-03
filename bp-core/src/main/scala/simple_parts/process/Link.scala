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

/**
 * Simple Link
 */

class BLink(start: Option[ProcElems], end: Option[ProcElems]) {
  def from: Option[ProcElems] = this.start
  def to: Option[ProcElems] = this.end
  BLink.links = BLink.links :+ this
}

object BLink {
  var links: List[BLink] = List()
  def relations = links.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)
}

object BLinkDispatch {
  def apply(target: Any) = println(target.getClass)
  def to(target: Any) = {
    val x = BLink.links.toList.filter(_.from == Some(target))
    x match {
      //case None => None
      case _ ⇒ x.map(_.to)
    }
  }
  def from(target: Any) = {
    InvokeTracer.runner.get.logger.log("dispatch invoked")
    val x = BLink.links.toList.find(_.to == Some(target))
    x match {
      case None ⇒ None
      case _    ⇒ x.get.from
    }
    //(BLink.links.toList.collect { case i if (i.to == Some(target)) => i }).head.from
  }
}