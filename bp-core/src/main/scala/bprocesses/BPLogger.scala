package main.scala.bprocesses

import main.scala.simple_parts.process._

/**
 * BPLogger
 */

class BPLogger {
  var logs: Array[BPLoggerResult] = Array.empty
  def log(result: BPLoggerResult) = {
    logs = logs :+ result
  }
}
case class BPLoggerResult(
  element: ProcElems, 
  invoked: Boolean, 
  expanded: Boolean, 
  order: Int, 
  space: Int, 
  station: BPStation)