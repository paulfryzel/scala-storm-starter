package storm.starter.bolt

object Exclaimer {
  def exclaim(s: String): String = {
    s + "!!!"
  }
}
