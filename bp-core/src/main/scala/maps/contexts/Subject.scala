package main.scala.maps.contexts
import scala.collection.mutable._
import main.scala.bprocesses._
import main.scala.bprocesses.links.ArgLink
import main.scala.bprocesses.links.PLink
import main.scala.maps.Frame

class Subject(title: String) {
  //var subj_elems: ListBuffer[Either[BProcess, BehavElement]] = ListBuffer()
  var subj_procs: ListBuffer[BProcess] = ListBuffer()
  // var subj_elems: ListBuffer[CtxElems] = ListBuffer()
  var frames: ListBuffer[Frame] = ListBuffer()

  /**
   *  Frame add by two methods
   *  First initialy [new Frame with @param]

   *  Second instantly [existed last frame with @param]
   
   */

  var arguments: ListBuffer[ArgLink] = ListBuffer()
  var params: ListBuffer[PLink] = ListBuffer()

  def arg_push(x: ArgLink) = arguments += x
  def param_push(x: PLink) = params += x
}