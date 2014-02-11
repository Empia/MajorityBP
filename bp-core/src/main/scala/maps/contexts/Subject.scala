package main.scala.MM
import scala.collection.mutable._
import main.scala.bprocesses._
import main.scala.simple_parts.process.ArgLink
import main.scala.simple_parts.process.PLink
class Subject(title: String) {
  //var subj_elems: ListBuffer[Either[BProcess, BehavElement]] = ListBuffer()
  var subj_procs: ListBuffer[BProcess] = ListBuffer()
  // var subj_elems: ListBuffer[CTXElems] = ListBuffer()
  var frames: ListBuffer[Frame] = ListBuffer()

  var arguments: ListBuffer[ArgLink] = ListBuffer()
  var params: ListBuffer[PLink] = ListBuffer()

  def arg_push(x: ArgLink) = arguments += x
  def param_push(x: PLink) = params += x
}