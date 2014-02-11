package examples
import main.scala.BProcess


//import util.Random
//import scala.collection.mutable._
/**
 * This specification shows how to create examples using the "acceptance" style

class HelloWorldSpec extends Specification { def is = s2"""
 
 This is a specification to check the 'Hello world' string

 The 'Hello world' string should
   contain 11 characters                             $e1
   start with 'Hello'                                $e2
   end with 'world'                                  $e3
   proc are filled                                   $e4
                                                     """

  def e1 = "Hello world" must have size(11)
  def e2 = "Hello world" must startWith("Hello")
  def e3 = "Hello world" must endWith("world")
  val proc = new BProcess(List("Stan", "Will"), "m")
  def e4 = (proc != new BProcess(List(), "m"))
} */