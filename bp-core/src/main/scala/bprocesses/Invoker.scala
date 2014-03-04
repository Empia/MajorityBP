package main.scala.bprocesses

import main.scala.simple_parts.process._
import main.scala.utils.Space
/**
 * Ivoking process
 */
class BPMarker(bp: BProcess) {
  var counter = 0
  def start = {
    // set initial value
    bp.station.update_started(true)
    move
  }
  def move:Boolean = {
    if (counter > 10) { // bp.station.step > bp.variety.length КОСЯК
      end 
      true
    }
    else 
     { 
     // station
        val elem = bp.variety(bp.station.step)
        if (true){//elem.isFront) { 
          front(elem) 
        }

      bp.logger.log(BPLoggerResult(elem, true, false, 1, 0, bp.station)) // (elem, true, false, elem.order, elem.space, bp.station)

      bp.station.update_step(bp.station.step + 1)
      counter = counter + 1
      move
     }
  }
  def end = {
    // toStation end
    bp.station.update_finished(true)

    println("end")
  }
  def toStation = {}
  def toLogger = {}


/* Instructions */
  // Front Elements
    def front(b: ProcElems) = b.invoke 
  // Space expanded elements
  // Space container
    def run_dim(dim: Space, proc: BProcess) {
      for (b ← dim.container) {
        if (proc.station.state) {
          println("Invoking the: " + b);
          b.invoke
          println(proc.station.step)
          //proc.step = proc.step + 1;
        } else {
          println(proc.station.step)
          //proc.status = "Paused"
        }
      }
    }

// * Start from middle
  // push elems
  // check expanders(through BPLogger)
  // start
  /*
  def run_from(proc: BProcess) = {
    proc.status = "Stop"
    proc.resume

    for (b ← (proc.variety.slice(proc.step, proc.variety.length + 1))) {
      if (proc.state) {
        println("Try invoking the: " + b);
        b.invoke

        proc.step = proc.step + 1;
      } else {

        proc.status = "Paused"
      }
    }

    if (proc.state && proc.status != "Paused") {
      proc.step = 0
      proc.status = "Complete/Stop"
    }
  }*/
}

object InvokeTracer {
  def run_proc(proc: BProcess) = proc.marker.start
}
