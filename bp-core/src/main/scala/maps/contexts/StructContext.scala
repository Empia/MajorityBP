package main.scala.MM

class StructContext(title: String) extends Context(title) {
  var subjects: List[Subject] = List()
  def represent = {
    println(s"Structure Context: $title")
    println(s"Subjects:")
    subjects.foreach(s ⇒ println(s.toString))
  }
  /**
   * Synergy for Resources [book]
   * Groups
   * Interaction between them
   */
}
