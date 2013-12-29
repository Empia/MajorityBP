/**
 *
 */
package main.scala.process_parts

/**
 * @author Sobolev
 *
 */

class BLink(start: Option[Brick], end: Option[Brick]) {
  def getTarget: Option[Brick] = this.start
  def getStart: Option[Brick]  = this.end
  BLink.links = BLink.links :+ this
}

object BLink { 
  var links:List[BLink] = List()
}