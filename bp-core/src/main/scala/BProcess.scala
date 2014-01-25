package main.scala
import main.scala.process_parts._
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
  /**
   * Executor
   */
  def run_init(proc: BProcess) = {
    for (b ← proc.variety) {
      if (proc.state) {
        if (isFront(b)) { //FIX THAT!!!!!!!!!!!!!!!!!
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

