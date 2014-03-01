package main.scala.bprocesses

import main.scala.simple_parts.process._
import main.scala.simple_parts.process.control._
import main.scala.simple_parts.process.data._
import main.scala.bprocesses.links._
import main.scala.utils.links.BPLinkContainer
import main.scala.utils.Space

class BProcess(resource: List[String]) extends BPLinkContainer[BPLink] {

/**
 *  State of process
 */
  var state = true
  var step = 0
  var status = "Stop"
  var variety: Array[ProcElems] = Array.empty[ProcElems]
  links = Array.empty[BPLink]
  val logger = new BPLogger

/**
 *  Process collection methods
 */
  def fetchSpace(index: Int) = variety.collect { 
    case space: Space => space }.find (space => space.dim == index)

  def blk = variety.collect { case block: Block ⇒ block }
  def rsl = variety.collect { case brick: Result ⇒ brick }
  def chk = variety.collect { case brick: Brick ⇒ brick }
  def cns = variety.collect { case const: Constant[_] ⇒ const }
  def inputs = variety.collect { case inputs: InputPlaceholder ⇒ inputs }

/**
 *  Owners
 */

/**
 * Input
 */
  def fill(in: Array[ProcElems]) = {
    val z = variety.collect { case placeholder: InputPlaceholder ⇒ placeholder }
    for (x ← z; y ← in) yield (x.push(y))
  }

/**
 * Push elements to process
 */
  def pushit(target: Array[ProcElems]) = {
    variety = variety ++ target
  }

  def push(f: ⇒ Array[ProcElems]) = {
    pushit(f)
  }

/**
 * Process information
 */
 def isCompleted = {
   step >= variety.length 
 }
 def isStarted = {
   step > variety.length 
 }
 def isPaused = {
   state == false && step != 0
 }

/**
 * Process initialization
 */

  // def init 

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

  //def returning = {
  // find return block
  // execute return block
  // push complete result 
  //}

}
