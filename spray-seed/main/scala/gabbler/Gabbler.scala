/*
 * Copyright 2013 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package name.heikoseeberger.gabbler

import GabblerService.Message
import akka.actor.{ Actor, FSM, Props }
import scala.concurrent.duration.FiniteDuration

object Gabbler {

  type Completer = Seq[Message] => Unit

  sealed trait State

  object State {
    case object Waiting extends State
    case object WaitingForMessage extends State
    case object WaitingForCompleter extends State
  }

  private case object Timeout

  def props(timeoutDuration: FiniteDuration): Props =
    Props(new Gabbler(timeoutDuration))
}

import Gabbler._
import State._

final class Gabbler(timeoutDuration: FiniteDuration) extends Actor with FSM[State, (Option[Completer], Seq[Message])] {

  startWith(Waiting, (None, Nil))

  when(Waiting) {
    case Event(completer: Completer, (None, Nil)) => goto(WaitingForMessage) using Some(completer) -> Nil
    case Event(message: Message, (None, Nil))     => goto(WaitingForCompleter) using None -> (message +: Nil)
    case Event(Timeout, _)                        => stop()
  }

  when(WaitingForMessage) {
    case Event(completer: Completer, (_, Nil)) =>
      stay using Some(completer) -> Nil
    case Event(message: Message, (Some(completer), Nil)) =>
      completer(message +: Nil)
      goto(Waiting) using None -> Nil
    case Event(Timeout, (Some(completer), Nil)) =>
      completer(Nil)
      goto(Waiting) using None -> Nil
  }

  when(WaitingForCompleter) {
    case Event(completer: Completer, (None, messages)) =>
      completer(messages)
      goto(Waiting) using None -> Nil
    case Event(message: Message, (None, messages)) =>
      stay using None -> (message +: messages)
    case Event(Timeout, _) =>
      stop()
  }

  onTransition {
    case _ -> WaitingForMessage | _ -> Waiting => setTimeout()
  }

  def setTimeout(): Unit =
    setTimer("timeout", Timeout, timeoutDuration, false)
}
