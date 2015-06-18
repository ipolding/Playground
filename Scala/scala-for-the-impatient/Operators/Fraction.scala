import scala.math.abs

class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);
    override def toString = num + "/" + den
    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
    def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

    def + (that: Fraction) : Fraction = {
        println("this.den = " + this.den)
        println("that.den = " + that.den)
        val lcm = this.den * that.den / gcd(this.den, that.den)
        val thisNewNum = this.num * lcm / this.den
        val thatNewNum = that.num * lcm / that.den
        return Fraction(thisNewNum + thatNewNum, lcm)
    }

    def * (that: Fraction) : Fraction = {
        return Fraction(this.num * that.num, this.den * that.den)
    }

    def - (that: Fraction) : Fraction = {
        println("this.den = " + this.den)
        println("that.den = " + that.den)
        val lcm = this.den * that.den / gcd(this.den, that.den)
        val thisNewNum = this.num * lcm / this.den
        val thatNewNum = that.num * lcm / that.den
        return Fraction(thisNewNum - thatNewNum, lcm)
    }


}

object Fraction{
    def apply(n: Int, d: Int) = new Fraction(n,d)
}

/*
val threeEighths = Fraction(3,8)
val quarter = Fraction(1,4)
threeEighths + quarter
*/