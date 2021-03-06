package main.scala
import main.scala.simple_parts.process._
import scala.collection.mutable._

class BProcess(resource: List[String]) {
  /**
   *  State of process
   */
  var state = true
  var step = 0
  var status = "Stop"
  var variety: ListBuffer[ProcElems] = ListBuffer()
  val logger = new BPLogger
  /**
   *  Links || Arguments, Parameters
   */

  var arguments: ListBuffer[ArgLink] = ListBuffer()
  var parameters: ListBuffer[PLink] = ListBuffer()

  def arg_push(x: ArgLink) = arguments += x
  def param_push(x: PLink) = parameters += x

  def showArguments = arguments.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)
  def showParameters = parameters.map(s ⇒ s.from.toString
    + Console.RED + " -> " + Console.WHITE +
    s.to.toString)

  /**
   *  Process collection methods
   */
  def blk = variety.collect { case block: Block ⇒ block }
  def rsl = variety.collect { case brick: Result ⇒ brick }
  def chk = variety.collect { case brick: Brick ⇒ brick }
  def cns = variety.collect { case const: Constant[_] ⇒ const }

  /**
   *  Owners
   */

  // def owners = ???

  /**
   * Input
   */
  def fill(in: ListBuffer[ProcElems]) = {
    val z = variety.collect { case placeholder: InputPlaceholder ⇒ placeholder }
    for (x ← z; y ← in) yield (x.push(y))
  }
  /**
   * Push elements to process
   */
  def pushit(target: ListBuffer[ProcElems]) = {
    variety = variety ++ target
  }

  def push(f: ⇒ ListBuffer[ProcElems]) = {
    pushit(f)
  }
  /**
   * Process initialization
   */

  // def init = ???

  def resume = {
    state = true
  }

  def stop(b: ProcElems) = {
    if (b.getClass.getSimpleName == "Stopper") {
      state = false
    }
  }

  def represent: String = {
    if (variety.length > 0) {
      var a = "\nProcess elements: \n\n***************\n"
      for (b ← variety) {
        a = a + b.toString + "\n" + "****************\n"
      }
      a
    } else { "Blank process" }
  }

}

/**
 * BPLogger
 */

class BPLogger {
  type Result = String
  var logs: ListBuffer[Result] = ListBuffer()
  def log(result: Result) = {
    logs = logs :+ result
  }
}

/**
 * Ivoking process
 */

object InvokeTracer {
  /*
   * Process instance
   */
  var runner: Option[BProcess] = None
  /*
   * Argument & Parameters Validation
   */
  import scala.util.Try
  def isValid(b: ProcElems): Boolean = {
    val t = Try(b.getClass.getMethod("arguments")).isSuccess
    val u = Try(b.getClass.getMethod("parameters")).isSuccess
    if (t) {
      argValid(b)
    } else if (u) {
      paramValid(b)
    } else {
      true
    }
  }
  def argValid(b: ProcElems): Boolean = {
    val x = ArgLinkDispatch.from(b)
    val y = x match {
      case None ⇒ None
      case _    ⇒ true
    }
    y != None
  }
  def paramValid(b: ProcElems): Boolean = {
    val x = PLinkDispatch.from(b)
    val y = x match {
      case None ⇒ None
      case _    ⇒ true
    }
    y != None
  }

  /**
   * Executor
   */
  def run_init(proc: BProcess) = {
    for (b ← proc.variety) {
      if (proc.state) {
        if (isValid(b) && isFront(b)) { //FIX THAT!!!!!!!!!!!!!!!!!
          // also add to run_from method
          println("Try invoking the: the: " + b);
          b.invoke
          println(proc.step)
          proc.step = proc.step + 1;
        }
      } else {
        println(proc.step)
        proc.status = "Paused"
      }
    }

    if (proc.state && proc.status != "Paused") {
      proc.step = 0
      proc.status = "Complete/Stop"
    }
  }

  def run_from(proc: BProcess) = {
    proc.status = "Stop"
    proc.resume

    for (b ← (proc.variety.slice(proc.step, proc.variety.length + 1))) {
      if (proc.state) {
        println("Try invoking the: " + b);
        b.invoke

        proc.step = proc.step + 1;
      } else {

        proc.status = "Paused"
      }
    }

    if (proc.state && proc.status != "Paused") {
      proc.step = 0
      proc.status = "Complete/Stop"
    }
  }
  def run_proc(proc: BProcess) = {
    runner = Option(proc)
    if (proc.step > 0) {
      run_from(proc)
    } else {
      run_init(proc)
    }
  }
  /**
   * * Dimension
   */
  def isFront(b: ProcElems): Boolean = {
    val x = BLinkDispatch.from(b)
    val y = x match {
      case None ⇒ None
      case _    ⇒ x.get.getClass.getSimpleName
    }
    y != "Dimension"
  }

  def run_dim(dim: Dimension, proc: BProcess) {
    for (b ← dim.container) {
      if (proc.state) {
        println("Invoking the: " + b);
        b.invoke
        println(proc.step)
        proc.step = proc.step + 1;
      } else {
        println(proc.step)
        proc.status = "Paused"
      }
    }
  }
}

