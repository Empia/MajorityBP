package main.scala.bprocesses

import main.scala.simple_parts.process._
import main.scala.simple_parts.process.control._
import main.scala.simple_parts.process.data._
import main.scala.bprocesses.links._
import main.scala.utils.links.BPLinkContainer
import main.scala.utils.Space

class BProcess(resource: List[String]) extends BPLinkContainer[BPLink] with BPFlow {

/**
 *  Field of process
 */

  var variety: Array[ProcElems] = Array.empty[ProcElems]
  links = Array.empty[BPLink]
  val logger = new BPLogger
  val station = new BPStation(this)
  val marker =  new BPMarker(this)
  val errors = new BPErrorCatcher(this)

/**
 *  Process collection methods
 */

  def blk = variety.collect { case block: Block ⇒ block }
  def rsl = variety.collect { case brick: Result ⇒ brick }
  def chk = variety.collect { case brick: Brick ⇒ brick }
  def cns = variety.collect { case const: Constant[_] ⇒ const }
  def inputs = variety.collect { case inputs: InputPlaceholder ⇒ inputs }
  def isContain(el: ProcElems) = variety contains el

  def getElemsLength = variety.length - variety.collect { case space: Space => space }.length
  def getSpaceByIndex(index: Int) = variety.collect { 
    case space: Space => space }.find (space => space.index == index)
  def getSpaceByOrder(order: Int) = variety.collect { 
    case space: Space => space }.find (space => space.order == order)
  def getSpacesByOrder(order: Int) = variety.collect { 
    case space: Space => space }.filter (space => space.order == order)
  def getSpaceQuantity = variety.collect { 
    case space: Space => space }.length
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
 * Process initialization
 */

  // def init 

/**
 * Process returning
 */

  //def returning = {
  // find return block
  // execute return block
  // push complete result 
  //}

}
