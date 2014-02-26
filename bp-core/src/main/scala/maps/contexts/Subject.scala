package main.scala.maps.contexts
import main.scala.bprocesses._
import main.scala.maps.Frame

class Subject(title: String) {
  //var subj_elems: ListBuffer[Either[BProcess, BehavElement]] = ListBuffer()
  var subj_procs: Array[BProcess] = Array.empty
  // var subj_elems: ListBuffer[CtxElems] = ListBuffer()
  var frames: Array[Frame] = Array.empty

  /**
   *  Frame add by two methods
   *  First initialy [new Frame with @param]
   */ 
   def init_frame(frame: Frame) = new Frame
   /**
    *  Second instantly [existed last frame with @param]
    */
   def inst_frame = frames.last

}