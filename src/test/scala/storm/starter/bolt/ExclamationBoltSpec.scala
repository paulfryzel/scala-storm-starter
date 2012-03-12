package storm.starter.bolt

import org.specs2.mutable._
import storm.starter.testing._

class ExclamationBoltSpec extends Specification {
  "The 'exclaim' method passed a string" should {
    "result in the original string  appended with '!!!' " in {
      val bolt = new ExclamationBolt()
      val original = "foo"
      val result = PrivateMethodExposer.p(bolt)('exclaim)(original)
      result must beEqualTo(original + "!!!")
    }
  }
}
