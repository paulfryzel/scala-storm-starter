package storm.starter.bolt

import org.specs2.mutable._

class ExclamationBoltSpec extends Specification {
  "The 'exclaim' method from Exclaimer passed a string" should {
    "result in the original string  appended with '!!!' " in {
      val bolt = new ExclamationBolt()
      val original = "foo"
      val result = Exclaimer.exclaim("foo")
      result must beEqualTo(original + "!!!")
    }
  }
}
