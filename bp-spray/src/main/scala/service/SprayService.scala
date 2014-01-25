package service

import akka.actor.{ ActorLogging, ActorRef, Props }
import akka.io.IO
import scala.concurrent.duration.FiniteDuration
import spray.can.Http
import spray.http.MediaTypes._
import spray.httpx.SprayJsonSupport
import spray.routing.{ HttpService, HttpServiceActor, Route }
import spray.json.DefaultJsonProtocol

case class MessagesList(title: String, container: List[Message])
case class Message(process: String, test: List[Int], typeof: String = getClass.getSimpleName) {
  // val typeof = getClass.toString
}

object MessageJsonProtocol extends DefaultJsonProtocol {
  implicit val format = jsonFormat3(Message)
  implicit val msgformat = jsonFormat2(MessagesList)
}
//object MessagesListJsonProtocol extends DefaultJsonProtocol {
//  implicit val format = jsonFormat2(MessagesList.apply)
//}
//
/**
 * Spray service
 *   - a REST under `spray-json-message/`
 *   - a HTML under `spray-html/`
 */

trait SprayService extends HttpService {

  //import MessagesListJsonProtocol._
  import spray.httpx.SprayJsonSupport._
  import DefaultJsonProtocol._
  import spray.json._
  import spray.httpx.SprayJsonSupport._
  import MessageJsonProtocol._
  def adRoute: Route =
    path("checkin") {
      get {
        complete {
          main.scala.Tryin1.context
          MessagesList("fff", List(
            Message("Service managers", List(1, 2, 3, 4)), Message("Service 1", List(1, 2, 3, 4)))) //.toJson
          //List(1, 2, 3)
          //Message("Hello mama!")
        }
      }
    } ~
      path("process" / IntNumber)(id ⇒
        get(
          complete(
            "Recived" + id))) ~
      pathPrefix("process" / IntNumber) { id ⇒
        path("blocks") {
          get {
            complete("checker" + id)
          }
        } ~
          path("logs") {
            get {
              complete("logs" + id)
            }
          }
      } ~
      pathPrefix("api") {
        path("launch") {
          get {
            // logs in array
            complete("launch")
          }
        } /* ~
          post {
            entity(as[Message]) { message ⇒
              complete {
                log.debug("User '{}' has posted '{}'", user.username, message.text)
                context.children foreach (_ ! message)
                StatusCodes.NoContent
              }
            }
            // invoke 
          }*/
      }

  //path("order" / IntNumber)(id =>
  //  get(
  //    complete(
  //      "Received GET request for order " + id 
  //    )
  //  ) ~
  //  put(
  //    complete(
  //      "Received PUT request for order " + id
  //    )
  //  )
  //)
  path("foo") {
    parameters('color, 'count.as[Int]) { (color, count) ⇒
      complete(s"The color is '$color' and you have $count of it.")
    }
  }

  //path("spray-html") {
  //  get {
  //    respondWithMediaType(`text/html`) {
  //      complete {
  //        <html>
  //          <body>
  //            <h1>Hello papa!</h1>
  //          </body>
  //        </html>
  //      }
  //    }
  //  }
  //}
}
