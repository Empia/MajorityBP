import main.scala.bprocesses.BProcess
import main.scala.simple_parts.process._

class BPReport(proc: BProcess) {
  type Result = String
  var logs: Map[ProcElems, Result] = Map()
}