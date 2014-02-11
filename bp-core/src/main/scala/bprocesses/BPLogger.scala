package main.scala.bprocesses

import main.scala.simple_parts.process._
import scala.collection.mutable._

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