package main.scala.bprocesses

class BPStation(val bp: BProcess) {
  // Учет состояние процесса
  var state = true
  var step = 0
  var space = 0
  var space_step = 0
  var started: Boolean = false
  var finished: Boolean = false
  var paused: Boolean = false

  def isStarted:Boolean = started
  def isRunned:Boolean  = started && !(finished && paused)
  def isPaused:Boolean  = paused

  def update_state(state: Boolean) = this.state = state
  def update_step(v: Int) = this.step = step
  def update_space(v: Int) = this.space = space
  def update_stace_step(v: Int) = this.space_step = space_step

  def update_started(s: Boolean) = this.started = s
  def update_paused(p: Boolean) = this.paused = p
  def update_finished(f: Boolean) = this.finished = f
}