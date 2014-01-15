/**
 *
 */
package main.scala.process_parts
import main.scala.InvokeTracer
/**
 * @author Sobolev
 *
 */

class BLink(start: Option[ProcElems], end: Option[ProcElems]) {
  def from: Option[ProcElems] = this.start
  def to: Option[ProcElems]  = this.end
  BLink.links = BLink.links :+ this
}

object BLink { 
  var links:List[BLink] = List()
  def relations = links.map(s => s.from.toString
                                   +Console.RED+" -> "+Console.WHITE+
                                 s.to.toString)
}

object BLinkDispatch 
{ 
  def apply(target: Any) = println(target.getClass)
  def to(target: Any) = {
    val x = BLink.links.toList.filter(_.from == Some(target)) 
    x match {
      //case None => None
      case _ => x.map(_.to)
    }
  }
  def from(target: Any) = { 
    InvokeTracer.runner.get.logger.log("dispatch invoked")
    val x = BLink.links.toList.find(_.to == Some(target)) 
    x match {
      case None => None
      case _ => x.get.from
    }
    //(BLink.links.toList.collect { case i if (i.to == Some(target)) => i }).head.from
  }
}