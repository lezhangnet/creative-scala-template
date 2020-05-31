import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._

object Section0906 extends App {
  println("zhale:Section0906:parametricCircle")

  def parametricCircle(angle: Angle): Point = 
    Point.polar(200, angle)

  def sample(samples: Int): Image = {
    val step = Angle.one / samples
    val dot = Image.triangle(10, 10)
      .fillColor(Color.limeGreen)
      .strokeColor(Color.lawngreen)
    
    def loop(count: Int): Image = {
      val angle = step * count
      count match {
        case 0 => Image.empty
        case n => dot.at(parametricCircle(angle)).on(loop(n-1))
      }
    }

    loop(samples)
  }

  sample(12).draw()
}
