/**
 * 
 * 
 */
package main.scala.process_parts


/**
 * @author Sobolev
 */
class Block(b_type:String, title:String, action: Any) extends ProcElems {

  override def toString = s"Title: $title"
  
  //b_type match {
  //case b_type:String => 
    //new_const(5)
//}
  override def invoke {
    println("invoked block")
  }
}

class Constant(num: Long) { 
  
  override def toString = s"Title: $num"
}

//class Loop {}
//class DataWork {}
// *  Data set
// *  Data get
// *  Data filter
//class Math {}
//class Sender {}
