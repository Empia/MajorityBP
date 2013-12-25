/**
 *
 */
package process_parts

/**
 * @author Sobolev
 *
 */
class Link(target: Option[Brick], to: Option[Brick]) {
  def getTarget: Option[Brick] = this.target
  Link.links = Link.links :+ this
}
object Link { 
  var links:List[Link] = List()
}