package main.scala.MM
import main.scala.simple_parts.context._
import main.scala.simple_parts.process._

class Request(block: CtxElems, Input: Array[ProcElems] = Array.empty) {
  def invoke(f: Frame) = {
    if (block.isRequestable) {
      block.fromReq(f)
      //block.invoke
    } else {
      println("Access to Block — Denied")
    }
  }
}