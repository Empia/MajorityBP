 /**
  * 
  */
package main.scala
import main.scala.process_parts._

/**
 * @author Sobolev
 *
 */
class BProcess(resource: List[String], scope: String) {
  
  type BlockType = String
  
  var state = true
  //var blocks = Seq()
  /** 
   *  Process methods
   *
  def blocks = ???
  def bricks = ???
  def elements = ???
  def bprocesses = ???
  */

  //def getBlocks = this.blocks
  
  def starting(f: => Any)= {
    println(">> f3")
    var blocks = f
    println("  got " + f.getClass)
    println("  goth " + f)
    println("  got " + f)
    println("<< f3")
   
  }
  def getBlocks():Any = return blocks
  def invoke() {
    /**
     * Check link after load object
     * Set a process steps
     * Brick retrive data from linked object
     * After freeze invoke must start from lastest step of Process
     *  def step = ???
     *  def status = ???
     */
   // for( b <- blocks){
   //      println( "Invoking the: " + b.invoke );
   // } 
  }
}
