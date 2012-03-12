package storm.starter.testing

/**
 * A class for exposing private methods in Scala
 * via: https://gist.github.com/908035
 *
 * @author Jorge Ortiz
 */
object PrivateMethodExposer {
  def p(x: AnyRef): PrivateMethodExposer = new PrivateMethodExposer(x)
}

class PrivateMethodExposer(x: AnyRef) {
  def apply(method: scala.Symbol): PrivateMethodCaller = new PrivateMethodCaller(x, method.name)
}
