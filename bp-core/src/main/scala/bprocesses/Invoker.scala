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

  /**
   * Executor
   */
  def run_init(proc: BProcess) = {
    for (b ← proc.variety) {
      if (proc.state) {
        if (InvokeChecker.isValid(b)) { // && isFront(b)) { //FIX THAT!!!!!!!!!!!!!!!!!
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
