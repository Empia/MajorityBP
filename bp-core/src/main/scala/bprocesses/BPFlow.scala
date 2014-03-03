package main.scala.bprocesses

import main.scala.simple_parts.process._



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