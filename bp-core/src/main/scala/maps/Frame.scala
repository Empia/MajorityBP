package main.scala.maps
import scala.collection.mutable._
import main.scala.utils.FrameLinkContainer
import main.scala.maps.Request

class Frame(title: String) extends FrameLinkContainer[PrLink] {
  var container: ListBuffer[Any] = ListBuffer()

  def fill(x: Any) = container += x

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