/**
 * 
 * 
 */

package process_parts

/**
 * @author Sobolev
 * Checker
 * Confirm
 * Sender
 * Result
 */
class Brick(br_type: String, mean: Unit, value: Unit, in: Unit, out: Unit) extends ProcElems {

    override def toString = s"Title: $mean"
    def invoke {
    println("invoked brick")
  }
    def link_from:Link = new Link(Option(this), true)
    
    def link_to:Link   = new Link(Option(this), false)
}