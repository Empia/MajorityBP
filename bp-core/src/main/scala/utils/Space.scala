package main.scala.utils
import main.scala.simple_parts.process._
import main.scala.bprocesses.InvokeTracer
import main.scala.bprocesses.links._

class Space(val order: Int, val index: Int) // increment index
    extends ProcElems 
{
  
private var state = true
var step = 0

// init
override def init { }

// subbricks
  var subbricks = Array.empty[SubBrick]

  def sb_pushit(target: Array[SubBrick]) {
    container = container ++ target
  }

  def sb_push(f: ⇒ Array[SubBrick]) = {
    sb_pushit(f)
  }


// container
  var container: Array[ProcElems] = Array.empty

  def cont_pushin(target: Array[ProcElems]) {
    container = container ++ target
  }

  def cont_push(f: ⇒ Array[ProcElems]) = {
    cont_pushin(f)
  }


// expandings
  var expands: Array[ProcElems] = Array.empty

  def exp_pushin(target: Array[ProcElems]) {
    expands = expands ++ target
  }

  def exps_push(f: ⇒ Array[ProcElems]) = {
    exp_pushin(f)
  }
  def doExpandObj(old: ProcElems, obj: ProcElems) = {
    expands.update(old, obj)
    // link_update
  }
  def doExpandInd(in: Int, obj: ProcElems) = {
    expands.update(expands(in), obj)
    // link_update
  } 

// runer
  def invoke = {
   //   pushit(ArgLinkDispatch.to(this).map(_.get).to[ListBuffer])
   //   InvokeTracer.run_dim(this, InvokeTracer.runner.get)
  }
}