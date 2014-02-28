package main.scala.maps
import main.scala.bprocesses.BProcess
import main.scala.simple_parts.context._
import main.scala.utils.links._

/**
 * Frame Link
 */

class CtxLink(start: Option[CtxElems], end: Option[CtxElems], nested: Frame, bprocess: Option[BProcess] = None) {
  def from: Option[CtxElems] = this.start
  def to: Option[CtxElems] = this.end
  def process: Option[BProcess] = this.bprocess
}
/**
 * Container
 */
object CtxLink extends FrameLinkContainer[CtxLink] {

}
/**
 * Searcher
 */
object CtxLinkSearcher extends LinkSearcher[CtxLink] {

}

object PrLinkDispatch {
  def apply(target: Any) = println(target.getClass)
  def to(target: Any) = {
    CtxLink.links.find(_.to == Some(target))
  }
  def from(target: Any) = {
    println("dispatch invoked")
    CtxLink.links.find(_.from == Some(target))
  }
}
