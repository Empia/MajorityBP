object tryin {
  import util.Random
  import process_parts._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(133); 

  /* Create process */
  val p = new Process(List("Stan", "Will"), "m");System.out.println("""p  : Process = """ + $show(p ));$skip(43); 
          
  def rnd = Random.nextInt(12);System.out.println("""rnd: => Int""");$skip(76); 
/**
 * Add blocks of process
 */
  p.add_block(p.block_init(s"start $rnd"));$skip(46); 
  p.add_block(p.block_init(s"data set $rnd"));$skip(48); 
  p.add_block(p.block_init(s"data check $rnd"));$skip(45); val res$0 = 
  p.add_brick(p.brick_init(s"confirm $rnd"));System.out.println("""res0: process_parts.Brick = """ + $show(res$0));$skip(44); 
  
  p.add_block(p.block_init(s"end $rnd"));$skip(34); 
  
  val t1: p.BlockType = "fff";System.out.println("""t1  : tryin.p.BlockType = """ + $show(t1 ));$skip(5); val res$1 = 
  t1;System.out.println("""res1: tryin.p.BlockType = """ + $show(res$1));$skip(166); val res$2 = 

/* Partial function to various type
p.blocks.foreach{
    case x:Block => x.block_method
    case _ =>
}
p.blocks.collect { case block: Block => block }
*/

p.state;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(35); 
/**
* Execute them
*/
  p.invoke();$skip(38); val res$3 = 
  

/**
 * Check state
 */
  p.state;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(183); 
  //blocks.left :+ new Block
  
  //trait Foo[M[_]] { type t[A] = M[A] }
  //val x: Foo[List]#t[Int] = List(1, 2)
  
 //Test bricks
 val proc = new Process(List("Stan", "Will"), "m");System.out.println("""proc  : Process = """ + $show(proc ));$skip(307); 
 // check links
 //proc.add_block("data", 16)
 //proc.add_block("data", 8)
 //proc.add_block("math", "+")
 //proc.add_brick("checker" 19)
 //proc.add_brick("result")
 
 
 //proc.add_brick(proc.brick_init("checker", 1+1, 2)).link_from
   //proc.add_link()
 val r1 = proc.add_brick(proc.brick_init("result"));System.out.println("""r1  : process_parts.Brick = """ + $show(r1 ));$skip(62); 
 val r2 = proc.add_brick(proc.brick_init("result"));System.out.println("""r2  : process_parts.Brick = """ + $show(r2 ));$skip(47); //.link_to
 
 val link = new Link(Option(r1), Option(r2));System.out.println("""link  : process_parts.Link = """ + $show(link ));$skip(42); val res$4 = 
 
Link.links.head.getTarget.get.getClass;System.out.println("""res4: Class[?0] = """ + $show(res$4))}

}
