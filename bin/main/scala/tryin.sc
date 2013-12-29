object tryin {
  import util.Random
  import main.scala.process_parts._

  /* Create process */
  val p = new BProcess(List("Stan", "Will"), "m")
          
  def rnd = Random.nextInt(12)
/**
 * Add blocks of process
 */
  p.add_block(p.block_init(s"start $rnd"))
  p.add_block(p.block_init(s"data set $rnd"))
  p.add_block(p.block_init(s"data check $rnd"))
  p.add_brick(p.brick_init(s"confirm $rnd"))
  
  p.add_block(p.block_init(s"end $rnd"))
  
  val t1: p.BlockType = "fff"
  t1

/* Partial function to various type
p.blocks.foreach{
    case x:Block => x.block_method
    case _ =>
}
p.blocks.collect { case block: Block => block }
*/

p.state
/**
* Execute them
*/
  p.invoke()
  

/**
 * Check state
 */
  p.state
  //blocks.left :+ new Block
  
  //trait Foo[M[_]] { type t[A] = M[A] }
  //val x: Foo[List]#t[Int] = List(1, 2)
  
 //Test bricks
 val proc = new Process(List("Stan", "Will"), "m")
 // check links
 //proc.add_block("data", 16)
 //proc.add_block("data", 8)
 //proc.add_block("math", "+")
 //proc.add_brick("checker" 19)
 //proc.add_brick("result")
 
 
 //proc.add_brick(proc.brick_init("checker", 1+1, 2)).link_from
   //proc.add_link()
 val r1 = proc.add_brick(proc.brick_init("result"))
 val r2 = proc.add_brick(proc.brick_init("result"))//.link_to
 
 val link = new BLink(Option(r1), Option(r2))
 r1.linked_to
BLink.links.head.getTarget.get.getClass

}