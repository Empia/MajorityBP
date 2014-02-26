package main.scala.maps
import main.scala.simple_parts.context._
import main.scala.simple_parts.process._

class Request(block: CtxElems, input: Array[ProcElems] = Array.empty) {
  def invoke(f: Frame) = {
    if (block.isRequestable) {
      block.fromReq(f, input)
    } else {
      println("Access to Block — Denied")
    }
  }
}