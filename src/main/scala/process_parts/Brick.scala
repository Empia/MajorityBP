/**
 * 
 * 
 */

package main.scala.process_parts

/**
 * @author Sobolev
 */
class Brick(br_type: String, mean: Unit, value: Unit, in: Unit, out: Unit) extends ProcElems {

    override def toString = s"Title: $mean"
    def invoke {
    println("invoked brick")
  }
    def linked_to = BLink.links.collect { case brick: Option[Brick] => brick }
   // def link_from:Link = new Link(Option(this), true)
   // def link_to:Link   = new Link(Option(this), false)
}
class Result(obj: Any) extends ProcElems {
  def invoke() {
  println(s"result $obj")
  }
}


class Checker {}
class Confirm {}
class Condition {}