/**
 *
 *
 */
package main.scala.simple_parts.process

import scala.collection.mutable._
import main.scala.simple_parts.process._
import main.scala.bprocesses.InvokeTracer

/**
 * @author Sobolev
 */

class Block(b_type: String, title: String) extends ProcElems {

  override def toString = s"Block: $title"

  override def invoke {
    InvokeTracer.runner.get.logger.log("invoked block")
  }
}

