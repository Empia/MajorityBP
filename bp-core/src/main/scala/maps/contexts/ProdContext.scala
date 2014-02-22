package main.scala.maps.contexts

class ProdContext(title: String) extends Context(title) {
  var subjects: List[Subject] = List()
}