package main.scala

import main.scala.simple_parts.process._
import main.scala.utils._

object Main extends App {
  Tryin2.argparams

  println(Calculator("5" + "*" + "10"))
  //  println(Calculator("5 * 10").getClass)
}

object Tryin2 {
  import util.Random
  import scala.collection.mutable._
  //import main.scala.MM._
  import main.scala.simple_parts.process._

  def param {
    val proc = new BProcess(List("Stan", "Will"))
    proc.push {
      ListBuffer[ProcElems](
        new Note("Test note"),
        new Result)
    }
    new BLink(Option(proc.variety(0)), Option(proc.variety(1)))
    InvokeTracer.run_proc(proc)
  }
  def argparams {
    val proc = new BProcess(List("Stan", "Will"))
    val input = new Note("Input note")
    proc.push {
      ListBuffer[ProcElems](
        //new Note("Test note"),
        //new Constant[Int](1001),
        //new Constant[Int](1001),
        new Constant[Boolean](true),
        //new Input(input),
        //new Checker,
        new Result, // must be true
        new Constant[Boolean](false),
        new InputPlaceholder)
    }
    //new BLink(Option(proc.variety(3)), Option(proc.variety(6)))
    //new BLink(Option(proc.variety(0)), Option(proc.variety(1)))

    new ArgLink(Option(proc.variety(0)), Option(proc.variety(1)))
    new ArgLink(Option(proc.variety(2)), Option(proc.variety(1)))
    println("arrrgs")
    println(ArgLink.links)

    proc.fill(ListBuffer[ProcElems](input))
    InvokeTracer.run_proc(proc)
  }
}
/*
object Tryin1 {
  import util.Random
  import scala.collection.mutable._
  import main.scala.MM._

  def apply {
    val proc = new BProcess(List("Stan", "Will"))
    proc.push {
      ListBuffer[ProcElems](
        new Note("Test note"),
        new Constant[Int](1001),
        new Brick(),
        new Brick(),
        new Result,
        // is front? not evaled

        new Condition(true),
        new Dimension,
        new Dimension,
        new Constant[Int](42),
        new Note("Condition note"),
        new Stopper,
        new Brick())

    }
    // Const -> Result
    val link_check = new BLink(Option(proc.variety(1)), Option(proc.variety(4)))
    // ???
    new BLink(Option(proc.variety.last), Option(proc.variety.head))
    // Condition dims
    new BLink(Option(proc.variety(5)), Option(proc.variety(6)))
    // Block to Dims
    new BLink(Option(proc.variety(6)), Option(proc.variety(9)))
    new BLink(Option(proc.variety(6)), Option(proc.variety(10)))

    InvokeTracer.run_proc(proc)
    println(proc.state)
    println(proc.status)
    println("------------------->")
    println("links are:")
    println(BLink.relations)

    println("proc status:")
    println(proc.status)
    println(proc.step)
    //InvokeTracer.run_proc(proc)
    println("proc status:")
    println(proc.status)
    println(proc.step)

    println("link from to cheking:")
    println(link_check.from)
    println(link_check.to)
    println(proc.logger.logs)
    //println(proc.represent)
    println(BLinkDispatch.to(proc.variety(6)).map(_.get).to[ListBuffer])
    println(InvokeTracer.isFront(proc.variety(9)))
  }
  def context {
    val Context = new StructContext("Accounting")
    Context.subject = List(new Subject("Make accounting"))
    Context.subject.head.subj_elems = ListBuffer(Left(new BProcess(List("Stan", "Will"))))
    val proc = Context.subject.head.subj_elems.head.left.get
    proc.variety = (ListBuffer[ProcElems](
      new Note("Test note"),
      new Constant[Int](1001),
      new Brick(),
      new Brick(),
      new Stopper,
      new Brick()))

    // Proc Links
    // Invoke
    // Process reports
    println(Context.represent)
    println("Process: ")
    println(proc.represent)
  }

}
*/

