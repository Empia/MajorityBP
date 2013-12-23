/**
 *
 */
package process_parts

/**
 * @author Sobolev
 *
 */
class Link(target: Option[Brick], direction: Boolean) extends ProcElems {
  def invoke:Unit = Unit
  def getTarget: Option[Brick] = this.target
  Link.links = Link.links :+ this
}
object Link { 
  var links:List[Link] = List()
}