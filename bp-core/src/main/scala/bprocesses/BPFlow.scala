package main.scala.bprocesses

import main.scala.simple_parts.process._


trait BPState {
  var state = true
  var step = 0
  var space_step = 0
  var status = "Stop"

}
trait BPFlow { this: BProcess =>
/**
 * Process flow
 */
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