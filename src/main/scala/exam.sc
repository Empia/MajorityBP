import util.Random
import main.scala._
import main.scala.process_parts._
import scala.collection.mutable._
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


 proc.starting {
 
 
   ListBuffer[ProcElems](
   new Constant(1001),
   new Brick("fff", Unit, Unit, Unit, Unit),
   new Brick("sss", Unit, Unit, Unit, Unit),
   new Result,
   new Stopper,
   new Brick("sss", Unit, Unit, Unit, Unit)
   )
 }
            
 new BLink(Option(proc.variety(0)), Option(proc.variety(3)))
 new BLink(Option(proc.variety.last), Option(proc.variety.head))
proc.rsl
 //chk.last.linked_to
BLink.links

InvokeTracer.run_proc(proc)

proc.state
proc.status
 
BLink.links.head.getTarget.get.getClass
}