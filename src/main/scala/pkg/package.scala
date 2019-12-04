package pkg

package object pkg {
  opaque type XCoord = Int
  object XCoord {
    def apply(v: String): XCoord = v.toInt
  }

  case class YCoord (private[pkg] val n: Int) extends AnyVal

  // in both cases, we'd need public factory constructors
  // to allow users to produce values of these types.
}