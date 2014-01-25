import main.scala.BProcess
import main.scala.process_parts._

class BPReport(proc: BProcess) {
  type Result = String
  var logs: Map[ProcElems, Result] = Map()
}