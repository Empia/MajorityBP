package main.scala

import main.scala.bprocesses._
import main.scala.simple_parts.process._
import main.scala.simple_parts.process.control._
import main.scala.simple_parts.process.data._
import main.scala.utils._
import main.scala.maps.contexts._
import main.scala.bprocesses.links._

object Main extends App {
  //Tryin2.argparams
  //Tryin3.frame
  //Tryin3.invoke_block
  //Tryin3.multiple_arg_p
  ///////////Tryin3.inputed
  ///////////Tryin3.invoke_block
  //  println(Calculator("5" + "*" + "10"))
  //  println(Calculator("5 * 10").getClass)
  val proc = new BProcess(List("Stan", "Will"))
  proc.push {
        Array[ProcElems](
        //new Note("Test note"),
        //new Constant[Int](1001),
        //new Constant[Int](1001),
        new Constant[Boolean](true),
        new Constant[Boolean](false))
        }
  val link = new BPLink(Option(proc.variety(0)), Option(proc.variety(1)), proc, true)      
  BPLinkSearcher.get_from(link)
}





/*
object Tryin3 {
  import main.scala.maps._
  import scala.collection.mutable._

  def invoke_block {
    import main.scala.simple_parts.context._
    val proc = new BProcess(List("Stan", "Will"))
    proc.push {
      ListBuffer[ProcElems](
        //new Note("Test note"),
        //new Constant[Int](1001),
        //new Constant[Int](1001),
        new Constant[Boolean](true),
        //new Input(input),,
        //new Checker,
        new Result, // must be true
        new Constant[Boolean](false),
        new InputPlaceholder,
        new Space)
    }
    val frame = new Frame("Ramka")
    frame.init

    val xx = new ProcInvoker
    frame.container += xx
    frame.container += proc

    // Input
    // Input null -> Process doest start

    new PrLink(Option(xx), Option(proc))
    frame.link_push(
      new PrLink(Option(frame.container(0).asInstanceOf[ProcInvoker]),
        Option(frame.container(1).asInstanceOf[BProcess])))

    println("frame links")
    println(frame.links)
    println(frame.container)
    // lazy val proc: BProcess = arguments.productIterator.toList.head.asInstanceOf[BProcess]
    // InvokeTracer.run_proc(proc)
    val inblock: ListBuffer[ProcElems] = ListBuffer(new Constant[Boolean](false))

    //frame.container(1).asInstanceOf[BProcess].fill(inblock)
    println(new ProcInvoker)
    println("request")
    println(frame.request(new Request(frame.container(0).asInstanceOf[ProcInvoker], inblock)))
  }

  def multiple_arg_p {
    val context = new StructContext("Accounting")
    context.subjects = List(new Subject("Taxes"))
    // Resource
    type Resource = List[String]
    val resource: Resource = List("Stan", "Will")
    // Process
    val proc = new BProcess(List("Stan", "Will"))
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

    proc.arg_push(new ArgLink(Option(proc.variety(0)), Option(proc.variety(1))))
    proc.arg_push(new ArgLink(Option(proc.variety(2)), Option(proc.variety(1))))
    println("arrrgs")
    InvokeTracer.run_proc(proc)
  }

  def frame {
    val context = new StructContext("Accounting")
    context.subjects = List(new Subject("Taxes"))
    // Resource
    type Resource = List[String]
    val resource: Resource = List("Stan", "Will")
    // Process
    val proc = new BProcess(List("Stan", "Will"))
    proc.push {
      ListBuffer[ProcElems](
        new Note("Test note"),
        new Result)
    }
    // Заполняем субьект процессом
    context.subjects.head.subj_procs += proc
    println(context.subjects.head.subj_procs)
    // Оборачиваем процесс в рамку
    val frame = new Frame("Ramka")
    println(frame)
    context.subjects.head.frames += frame
    println(context.subjects.head.frames)
    // Рамка готова
    // В рамку можно пихать любые объекты для субьекта
    context.subjects.head.frames.head.container += proc // Добавили процесс
    println(context.subjects.head.frames.head.toString)
  }

  def context {
    // Context
    val context = new StructContext("Accounting")
    context.subjects = List(new Subject("Taxes"))
    // Resource
    type Resource = List[String]
    val resource: Resource = List("Stan", "Will")
    // Process
    val proc = new BProcess(List("Stan", "Will"))
    proc.push {
      ListBuffer[ProcElems](
        new Note("Test note"),
        new Result)
    }
    // Links
    new ArgLink(Option(proc.variety(0)), Option(proc.variety(1)))

    // Push proc to subject
    context.subjects.head.subj_procs = ListBuffer(proc)
    // Run proc
    import main.scala.simple_parts.context._

    //InvokeTracer.run_proc(proc)

    //println(new ProcInvoker)
    /*
    ProcessFlow(proc).status
    return can it run? if not why
    Checker is valid arg params
      is arg set
      optional param args
      inputcheck

    proc.input not found?
    proc.paused
    proc.input_push(block)
    push.invoke
    proc.contin
    */

    println(context.subjects.head.subj_procs)
    println("********")
    println((new Result).isOptionalArg)
  }

  def inputed {
    import main.scala.simple_parts.context._

    val xx = new ProcInvoker
    val proc = new BProcess(List("Stan", "Will"))
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
    val frame = new Frame("Ramka")
    frame.init

    new PrLink(Option(xx), Option(proc))
    // lazy val proc: BProcess = arguments.productIterator.toList.head.asInstanceOf[BProcess]
    // InvokeTracer.run_proc(proc)
    println(new ProcInvoker)
    println("request")
    println(new Request(xx))
  }
}
*/

/*
object Tryin2 {
  import util.Random
  import scala.collection.mutable._
  import main.scala.simple_parts.process._

  def param {
    val proc = new BProcess(List("Stan", "Will"))
    proc.push {
      ListBuffer[ProcElems](
        new Note("Test note"),
        new Result)
    }
    new ArgLink(Option(proc.variety(0)), Option(proc.variety(1)))
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

    proc.arg_push(new ArgLink(Option(proc.variety(0)), Option(proc.variety(1))))
    proc.arg_push(new ArgLink(Option(proc.variety(2)), Option(proc.variety(1))))
    println("arrrgs")
    println(proc.arguments)

    proc.fill(ListBuffer[ProcElems](input))
    InvokeTracer.run_proc(proc)
  }
}
*/






