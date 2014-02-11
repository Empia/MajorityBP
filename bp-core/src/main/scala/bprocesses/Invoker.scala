package main.scala.bprocesses

import main.scala.simple_parts.process._
import main.scala.utils.Dimension
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
    val u = Try(b.getClass.getMethod("params")).isSuccess
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
        if (isValid(b)) { // && isFront(b)) { //FIX THAT!!!!!!!!!!!!!!!!!
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
  //def isFront(b: ProcElems): Boolean = {
  //  val x = ArgLinkDispatch.from(b)
  //  val y = x match {
  //    case None ⇒ None
  //    case _    ⇒ x.get.getClass.getSimpleName
  //  }
  //  y != "Dimension"
  //}

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
