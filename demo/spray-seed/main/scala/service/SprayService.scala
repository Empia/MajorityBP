package service

import akka.actor.{ ActorLogging, ActorRef, Props }
import akka.io.IO
import scala.concurrent.duration.FiniteDuration
import spray.can.Http
import spray.http.MediaTypes._
import spray.httpx.SprayJsonSupport
import spray.routing.{HttpService, HttpServiceActor, Route}
import spray.json.DefaultJsonProtocol


case class Message(username: String, test: List[Int])

object MessageJsonProtocol extends DefaultJsonProtocol {
  implicit val format = jsonFormat2(Message)
}

/**
 * Spray service
 *   - a REST under `spray-json-message/`
 *   - a HTML under `spray-html/`
 */
case class Tester(name: String)

trait SprayService extends HttpService {

  import MessageJsonProtocol._
  import spray.httpx.SprayJsonSupport._

  def adRoute : Route =
    path( "checkin" ) {
      get {
        complete {
          Message("jacke", List(1,2,3))

          //Message("Hello mama!")
        }
      }
    } ~
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
      parameters('color, 'count.as[Int]) { (color, count) =>
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
