package main.scala.bprocesses

import main.scala.simple_parts.process._
import main.scala.simple_parts.process.control._
import main.scala.simple_parts.process.data._
import scala.collection.mutable._
import main.scala.utils.BPLinkContainer

class BProcess(resource: List[String]) extends BPLinkContainer {
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
  def inputs = variety.collect { case inputs: InputPlaceholder ⇒ inputs }

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

  //def returning = {
  // find return block
  // execute return block
  // push complete result 
  //}

}
