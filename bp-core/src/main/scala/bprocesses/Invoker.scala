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
    toStation(bp).update_started(true)
    move
  }
  def move:Unit = {
    if (counter > 10) // bp.station.step > bp.variety.length КОСЯК
    { 
      end 
      true
    }
    else 
    { 
     // station
        val elem = bp.variety(toStation(bp).step)
        if (true){//elem.isFront) { 
          front(elem) 
        }

      toLogger(bp, BPLoggerResult(elem, true, false, 1, 0, toStation(bp))) // (elem, true, false, elem.order, elem.space, bp.station)

      toStation(bp).update_step(bp.station.step + 1)
      counter = counter + 1
      if (isInFront) { 
        println("station")
        println(station.isInFront)
        move 
        
      }
    }
  }
  
  def end = {
    // toStation end
    toStation(bp).update_finished(true)

    println("end")
  }
  // Moving of marker
  def moveToSpace = { 
    station.inSpace(true)

  }
  def moveToExpand = {
    station.inExpand(true)
    station.update_expand_step(0)
  }
  def moveToContainer = {
    station.inContainer(true)
    station.update_container_step(0)
  }
  // up
  def moveUpFront = {
    station.inExpand(false)
    station.inContainer(false)
    
    station.flush_container_step
    station.flush_expand_step
  }
  def moveUpFrontSpace = {
    station.inSpace(true)

    station.inExpand(false)
    station.inContainer(false)
    
    station.flush_container_step
    station.flush_expand_step
  }
  // exec
  def invokeExpand = {}
  def invokeContainer = {}

  // Push Info
  val station = bp.station
  def isInFront: Boolean = true// station.isInFront
  def toStation(bp: BProcess): BPStation = { bp.station }
  def toLogger(bp: BProcess, result: BPLoggerResult) = bp.logger.log(result)


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
