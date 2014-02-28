package main.scala.utils.links
import main.scala.bprocesses._
import main.scala.bprocesses.links._

trait LinkContainer {
  // BP Links
  // Ctx Links
}

trait BPLinkContainer[T] extends LinkContainer { self =>
  
  var links: Array[T] = _

  def add_link(x: T) = links :+ x

  //def showLinks = links.map(s ⇒ s.from.toString
  //  + Console.RED + " -> " + Console.WHITE +
  //  s.to.toString)

}


trait FrameLinkContainer[T] extends LinkContainer { self =>
  
  var links: Array[T] = _

  def add_link(x: T) = links :+ x

  //def showLinks = links.map(s ⇒ s.from.toString
  //  + Console.RED + " -> " + Console.WHITE +
  //  s.to.toString)
}