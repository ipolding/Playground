class MutablePair[T](var first: T, var second: T) {

    def swap = {val swap : T = first; this.first = this.second; this.second = swap}

    override def toString : String = {
        this.getClass.getName + "(" + first + ", " + second + ")"
    } 
}