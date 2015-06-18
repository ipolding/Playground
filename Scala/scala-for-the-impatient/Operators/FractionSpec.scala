class FractionSpec extends UnitSpec {

  "1/4 + 3/8" should "equal 5/8" in {
    val quarter: Fraction = new Fraction(1,4)
    val threeEigths: Fraction = new Fraction(3,8)
    assert((quarter + threeEigths).toString.equals("5/8") )
    }

  /*it should "produce NoSuchElementException when head is invoked" in {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }*/
}