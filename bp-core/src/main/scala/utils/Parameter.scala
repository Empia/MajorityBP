package main.scala.utils
import main.scala.simple_parts.process._

trait ParamDispatch { self ⇒
  // validate type of param
  // handle many param  
  def parameters = PLinkDispatch.from(this)
  def param_valid = self.parameters.isDefined

}