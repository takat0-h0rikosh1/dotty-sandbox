object MyObject {

  opaque type MyInt = Int

  object MyInt {
    def apply(i: Int): MyInt = i
  }

  given MyIntOps: {
    def (x: MyInt) getInt: Int = x.toInt
    def (x: MyInt) + (y: MyInt): MyInt = MyInt(x + y)
    def (x: MyInt) * (y: MyInt): MyInt = MyInt(x *y)
  }
}
