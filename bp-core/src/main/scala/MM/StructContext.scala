package main.scala.MM

class StructContext(title: String) extends Context(title) {
  var subject: List[Subject] = List()
  def represent = {
    println(s"Structure Context: $title")
    println(s"Subjects:")
    subject.foreach(s ⇒ println(s.toString))
  }
}
