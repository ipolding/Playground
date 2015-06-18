class Money(private val dollars: Int, private val cents: Int) {

	if (cents > 99 | cents <0) {throw new IllegalArgumentException("Cents must be between 0 and 99")}

	def + (that: Money) : Money = {
		val dollarSum = this.dollars + that.dollars + ((this.cents + that.cents) / 100)
 		val centsSum = (this.cents + that.cents) % 100
		Money(dollarSum, centsSum)
	}

	def - (that: Money) : Money = {
		val dollarSum = this.dollars - that.dollars + ((this.cents - that.cents) / 100)
 		val centsSum = (this.cents - that.cents) % 100
		Money(dollarSum, centsSum)
	}
/*
    def < (that: Money) : Boolean = {
        if (this.dollars < that.dollthis.cents * multiplier)ars) 
        {return true}
        else 
        if (this.dollars == that.dollars) {return (this.cents < that.cents)}
    } */
    def * (multiplier: Int) : Money = {
        val dollarProduct = this.dollars * multiplier + ((this.cents * multiplier)/100)
        val centsProduct = (this.cents * multiplier) % 100
        Money(dollarProduct, centsProduct)

    }

	override def toString : String = "Money("+this.dollars + "," + this.cents+")"
}

object Money {

	def apply(dollars: Int, cents: Int) = new Money(dollars, cents)

}
