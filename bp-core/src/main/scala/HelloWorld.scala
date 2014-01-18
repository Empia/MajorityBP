package main.scala

import main.scala.process_parts._
import main.scala.utils._

object Main extends App {
  Tryin1.apply

  //  println(Calculator("5 * 10"))
  //  println(Calculator("5 * 10").getClass)
}
object Condtryin {

}
object Tryin1 {
  import util.Random
  import scala.collection.mutable._

  def apply {
    val proc = new BProcess(List("Stan", "Will"))
    proc.push {
      ListBuffer[ProcElems](
        new Note("Test note"),
        new Constant[Int](1001),
        new Brick("fff", Unit, Unit, Unit, Unit),
        new Brick("sss", Unit, Unit, Unit, Unit),
        new Result,
        // is front? not evaled

        new Condition(true),
        new Dimension,
        new Dimension,
        new Constant[Int](42),
        new Note("Condition note"),
        new Stopper,
        new Brick("sss", Unit, Unit, Unit, Unit))

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

  val proc = new BProcess(List("Stan", "Will"))
  proc.push {
    ListBuffer[ProcElems](
      new Note("Test note"),
      new Constant[Int](1001),
      new Brick("fff", Unit, Unit, Unit, Unit),
      new Brick("sss", Unit, Unit, Unit, Unit),
      new Result,
      // is front? not evaled

      new Condition(true),
      new Dimension,
      new Dimension,
      new Constant[Int](42),
      new Note("Condition note"),
      new Stopper,
      new Brick("sss", Unit, Unit, Unit, Unit))

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

  def logs = proc.logger.logs
}
