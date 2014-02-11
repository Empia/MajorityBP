package main.scala.utils
import main.scala.simple_parts.process._
/**
 *  Param — Valuable elements of object
 */
trait ParamDispatch { self ⇒
  // validate type of param
  // handle many param  
  def params = PLinkDispatch.from(this)
  def isParamsExist = self.params.isDefined

  //def isMultiple = Try(arguments.getClass.getMethod("head")).isSuccess
  val isParamList = false
  val isOptionalParam = false
}