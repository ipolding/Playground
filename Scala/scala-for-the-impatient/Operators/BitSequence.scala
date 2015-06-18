/*
Implement a class BitSequence that stores a sequence of 64 bits packed in a long value. 

Supply apply and update operators to get and set an individual bit 
*/

class BitSequence(bits: Long) {

	override def toString : String = bits.toBinaryString

}


