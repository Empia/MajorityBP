object tryin {
  import util.Random
  import process_parts._

  /* Create process */
  val p = new Process(List("Stan", "Will"), "m")  //> p  : Process = Process@1032d84
          
  def rnd = Random.nextInt(12)                    //> rnd: => Int
/**
 * Add blocks of process
 */
  p.add_block(p.block_init(s"start $rnd"))
  p.add_block(p.block_init(s"data set $rnd"))
  p.add_block(p.block_init(s"data check $rnd"))
  p.add_brick(p.brick_init(s"confirm $rnd"))      //> res0: process_parts.Brick = Title: ()
  
  p.add_block(p.block_init(s"end $rnd"))
  
  val t1: p.BlockType = "fff"                     //> t1  : tryin.p.BlockType = fff
  t1                                              //> res1: tryin.p.BlockType = fff

/* Partial function to various type
p.blocks.foreach{
    case x:Block => x.block_method
    case _ =>
}
p.blocks.collect { case block: Block => block }
*/

p.state                                           //> res2: Boolean = true
/**
* Execute them
*/
  p.invoke()                                      //> invoked block
                                                  //| Invoking the: ()
                                                  //| invoked block
                                                  //| Invoking the: ()
                                                  //| invoked block
                                                  //| Invoking the: ()
                                                  //| invoked brick
                                                  //| Invoking the: ()
                                                  //| invoked block
                                                  //| Invoking the: ()
  

/**
 * Check state
 */
  p.state                                         //> res3: Boolean = true
  //blocks.left :+ new Block
  
  //trait Foo[M[_]] { type t[A] = M[A] }
  //val x: Foo[List]#t[Int] = List(1, 2)
  
 //Test bricks
 val proc = new Process(List("Stan", "Will"), "m")//> proc  : Process = Process@15538e5
 // check links
 //proc.add_block("data", 16)
 //proc.add_block("data", 8)
 //proc.add_block("math", "+")
 //proc.add_brick("checker" 19)
 //proc.add_brick("result")
 
 
 //proc.add_brick(proc.brick_init("checker", 1+1, 2)).link_from
   //proc.add_link()
 val r1 = proc.add_brick(proc.brick_init("result"))
                                                  //> r1  : process_parts.Brick = Title: ()
 val r2 = proc.add_brick(proc.brick_init("result"))//.link_to
                                                  //> r2  : process_parts.Brick = Title: ()
 
 val link = new Link(Option(r1), Option(r2))      //> link  : process_parts.Link = process_parts.Link@f4b65d
 r1.linked_to                                     //> res4: List[process_parts.Link with Option[process_parts.Brick]] = List()
Link.links.head.getTarget.get.getClass            //> res5: Class[?0] = class process_parts.Brick

}