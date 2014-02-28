package main.scala.maps
import main.scala.utils.links.FrameLinkContainer

class Frame(title: String = "") extends FrameLinkContainer[CtxLink] {
  
  var container: Array[Any] = Array.empty[Any]
  links = Array.empty[CtxLink]

  def fill(x: Any) = container :+ x

  override def toString = s"Frame: $title Contains " + container.length

  def init {
    FrameTracer.runner = Option(this)
  }

  def request(r: Request) {
    r.invoke(this)
  }
}
object FrameTracer {
  var runner: Option[Frame] = None
}