object Main {

  def main(args: Array[String]): Unit = {
    println("Hello world!")
    println(msg)
  }

  def msg = "I was compiled by dotty :)"

}

object Logarithms {

  opaque type Logarithm = Double

  object Logarithm {

    // These are the ways to lift to the logarithm type
    def apply(d: Double): Logarithm = math.log(d)

    def safe(d: Double): Option[Logarithm] =
      if (d > 0.0) Some(math.log(d)) else None
  }

  // Extension methods define opaque types' public APIs
  given logarithmOps: {
    def (x: Logarithm) toDouble: Double = math.exp(x)
    def (x: Logarithm) + (y: Logarithm): Logarithm = Logarithm(math.exp(x) + math.exp(y))
    def (x: Logarithm) * (y: Logarithm): Logarithm = Logarithm(x + y)
  }
}

case class Label(v: String)
object Sandbox {

  val first = Label("first")
  val second = Label("second")
  
  // List(first, second)
  // (first, second)
}

object MyContext {
  private case class Inside(v: Int)
  opaque type Outside = Inside
  object Outside {
    def apply(v: Int): Outside= Inside(v)
  }
}