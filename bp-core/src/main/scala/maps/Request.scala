package main.scala.maps
import main.scala.simple_parts.context._
import main.scala.simple_parts.process._
import scala.collection.mutable._

class Request(block: CtxElems, input: ListBuffer[ProcElems] = ListBuffer.empty) {
  def invoke(f: Frame) = {
    if (block.isRequestable) {
      block.fromReq(f, input)
    } else {
      println("Access to Block — Denied")
    }
  }
}