/**
 * 
 * 
 */
package process_parts


/**
 * @author Sobolev
 *  Condition
 *  Loop
 *  Data set
 *  Data get
 *  Data filter
 *  Math
 */
class Block(b_type:String, title:String, action: Unit, a_link: Boolean) extends ProcElems {

  override def toString = s"Title: $title"
  
  def block_method = println("1")
  
  override def invoke {
    println("invoked block")
  }
}