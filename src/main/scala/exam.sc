import util.Random
import main.scala._
import main.scala.process_parts._
/*****************************$$%$%#%$#%#%#$%#
*** Link val to arg
**  Implement main trait
**  Implement elements
**  Implement nested processes
*/
object exam {

def rnd = Random.nextInt(12)
/* Create process */
val proc = new BProcess(List("Stan", "Will"), "m")
// check links
//proc.add_block("data", 16)
//proc.add_block("data", 8)
//proc.add_block("math", "+")
//proc.add_brick("checker" 19)
//proc.add_brick("result")
 
 
  //def block_init(title:String):Block = new Block("ops", title, uni, true)
  //def brick_init(title:String):Brick = new Brick("", Unit, Unit, Unit, Unit)
 //proc.add_brick(proc.brick_init("checker", 1+1, 2)).link_from
   //proc.add_link()
// val r1 = proc.add_brick(new Brick("", Unit, Unit, Unit, Unit))
// val r2 = proc.add_brick(new Result("fff"))//.link_to
//r2.invoke

 
 //with Constant
 // Launch process elements
 proc.starting {
   Seq
   (
   new Constant(1001),
   new Brick("fff", Unit, Unit, Unit, Unit),
   new Brick("sss", Unit, Unit, Unit, Unit),
   new Brick("sss", Unit, Unit, Unit, Unit),
   new Brick("sss", Unit, Unit, Unit, Unit),
   new Brick("sss", Unit, Unit, Unit, Unit)
   )
 }

              
 proc.blocks
 
 
 
// val link = new BLink(Option(r1), Option(r2))
// r1.linked_to
BLink.links.head.getTarget.get.getClass
}