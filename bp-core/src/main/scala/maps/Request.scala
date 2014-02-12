package main.scala.MM
import main.scala.simple_parts.context._
import main.scala.simple_parts.process._

class Request(block: CtxElems, Input: Array[ProcElems] = Array.empty) {
  if (block.isRequestable) {
    block.invoke
  } else {
    println("Access to Block — Denied")
  }

}