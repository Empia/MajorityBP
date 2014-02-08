package main.scala.MM

import scala.collection.mutable._

class Frame(title: String) {
  var container: ListBuffer[Any] = ListBuffer()

  def fill(x: Any) = container += x

  override def toString = s"Frame: $title Contains " + container.length

  def init {
    FrameTracer.runner = Option(this)
  }
  // Process
  // Blocks
  // Arguments
  // Parameters
}
object FrameTracer {
  var runner: Option[Frame] = None
}