package main.scala.utils
import scala.collection.mutable._
import main.scala.simple_parts.process._
import main.scala.bprocesses.InvokeTracer
import main.scala.bprocesses.links._

class Space
    extends ProcElems {
  
  private var state = true
 
// init


// subbricks
  // Array[SubBrick]
      // add SubBrick = argument, parameter [fetch arg outside space, and betwen space]
      // SubBrick return results & return result


// container
  var container: Array[ProcElems] = Array.empty

  def pushit(target: Array[ProcElems]) {
    container = container ++ target
  }

  def push(f: ⇒ Array[ProcElems]) = {
    pushit(f)
  }



// expandings
  // by default return last element of container(withoud call on it return)
  



// easy access[read, write] from BProcess (3,1 4,1 5,1)




// runer
 // def invoke = {
 //   pushit(ArgLinkDispatch.to(this).map(_.get).to[ListBuffer])
 //   InvokeTracer.run_dim(this, InvokeTracer.runner.get)
 // }
}