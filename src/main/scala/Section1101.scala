import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._

object Section1101 extends App {
  println("zhale:Section1101:Reactors")

  val travellingCircle = Reactor.init(Point(-300, 0))
    .onTick(pt => Point(pt.x + 1, pt.y))
    .render(pt => Image.circle(10).at(pt))
    .stop(pt => pt.x >= 300)

  travellingCircle.run(Frame.size(600, 600))

  val orbitingCircle = Reactor.init(Point(0, 300))
    .onTick(pt => pt.rotate(2.degrees))
    .render(pt => Image.circle(10).at(pt))

  orbitingCircle.run(Frame.size(600, 600))
}
