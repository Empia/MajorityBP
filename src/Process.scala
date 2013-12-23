 /**
  * 
  */
import process_parts._

/**
 * @author Sobolev
 *
 */
class Process(resource: List[String], scope: String) {
  
  type BlockType = String
  
  var state = true
  var blocks:List[ProcElems] = List()
  val uni:Unit = None
  
  def block_init(title:String):Block = new Block("ops", title, uni, true)
  def brick_init(title:String):Brick = new Brick("", Unit, Unit, Unit, Unit)
  
  def add_block(b: Block) = {
      blocks = blocks :+ b
  }
  
  def add_brick(b: Brick):Brick = {
      blocks = blocks :+ b
      b
  }
  def invoke() {
    for( b <- blocks){
         println( "Invoking the: " + b.invoke );
    } 
  }
}