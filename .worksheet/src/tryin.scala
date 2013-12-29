object tryin {
  import util.Random
  import main.scala.process_parts._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(145); 

  /* Create process */
  val p = new BProcess(List("Stan", "Will"), "m");System.out.println("""p  : <error> = """ + $show(p ));$skip(42); 
          
  def rnd = Random.nextInt(12);System.out.println("""rnd: => Int""");$skip(76); val res$0 = 
/**
 * Add blocks of process
 */
  p.add_block(p.block_init(s"start $rnd"));System.out.println("""res0: <error> = """ + $show(res$0));$skip(46); val res$1 = 
  p.add_block(p.block_init(s"data set $rnd"));System.out.println("""res1: <error> = """ + $show(res$1));$skip(48); val res$2 = 
  p.add_block(p.block_init(s"data check $rnd"));System.out.println("""res2: <error> = """ + $show(res$2));$skip(45); val res$3 = 
  p.add_brick(p.brick_init(s"confirm $rnd"));System.out.println("""res3: <error> = """ + $show(res$3));$skip(44); val res$4 = 
  
  p.add_block(p.block_init(s"end $rnd"));System.out.println("""res4: <error> = """ + $show(res$4));$skip(33); 
  
  val t1: p.BlockType = "fff";System.out.println("""t1  : <error> = """ + $show(t1 ));$skip(5); val res$5 = 
  t1;System.out.println("""res5: <error> = """ + $show(res$5));$skip(166); val res$6 = 

/* Partial function to various type
p.blocks.foreach{
    case x:Block => x.block_method
    case _ =>
}
p.blocks.collect { case block: Block => block }
*/

p.state;System.out.println("""res6: <error> = """ + $show(res$6));$skip(35); val res$7 = 
/**
* Execute them
*/
  p.invoke();System.out.println("""res7: <error> = """ + $show(res$7));$skip(37); val res$8 = 
  

/**
 * Check state
 */
  p.state;System.out.println("""res8: <error> = """ + $show(res$8));$skip(183); 
  //blocks.left :+ new Block
  
  //trait Foo[M[_]] { type t[A] = M[A] }
  //val x: Foo[List]#t[Int] = List(1, 2)
  
 //Test bricks
 val proc = new Process(List("Stan", "Will"), "m");System.out.println("""proc  : <error> = """ + $show(proc ));$skip(307); 
 // check links
 //proc.add_block("data", 16)
 //proc.add_block("data", 8)
 //proc.add_block("math", "+")
 //proc.add_brick("checker" 19)
 //proc.add_brick("result")
 
 
 //proc.add_brick(proc.brick_init("checker", 1+1, 2)).link_from
   //proc.add_link()
 val r1 = proc.add_brick(proc.brick_init("result"));System.out.println("""r1  : <error> = """ + $show(r1 ));$skip(62); 
 val r2 = proc.add_brick(proc.brick_init("result"));System.out.println("""r2  : <error> = """ + $show(r2 ));$skip(48); //.link_to
 
 val link = new BLink(Option(r1), Option(r2));System.out.println("""link  : main.scala.process_parts.BLink = """ + $show(link ));$skip(14); val res$9 = 
 r1.linked_to;System.out.println("""res9: <error> = """ + $show(res$9));$skip(40); val res$10 = 
BLink.links.head.getTarget.get.getClass;System.out.println("""res10: <error> = """ + $show(res$10))}

}
