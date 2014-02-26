package main.scala.bprocesses

import main.scala.simple_parts.process._

/**
 * BPLogger
 */

class BPLogger {
  type Result = String
  var logs: Array[Result] = Array.empty
  def log(result: Result) = {
    logs = logs :+ result
  }
}