import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._

// "cross" in section 7.4
object Example74 {
  def cross(count: Int): Image = {
    count match {
      case 0 =>
        Image.regularPolygon(6, 10, 0.degrees)
          .strokeColor(Color.deepSkyBlue.spin(-180.degrees))
          .strokeWidth(5.0)
      case n =>
        val circle = Image
          .circle(20)
          .strokeColor(Color.deepSkyBlue)
          .on(Image.circle(15).strokeColor(Color.deepSkyBlue.spin(-15.degrees)))
          .on(Image.circle(10).strokeColor(Color.deepSkyBlue.spin(-30.degrees)))
          .strokeWidth(5.0)
        circle.beside(
          circle.above(
            cross(n - 1)
          ).above(circle)
        ).beside(circle)
    }
  }

  def main(args: Array[String]): Unit = {
    cross(10).draw()
  }
}
