/* given a class Pair[T, S], write a generic method swap that takes in a pair as its argument and returns a new pair with its components swapped. */

class Pair[T, S](val first : T, val second: S) {}

def swap[T, S](pair: Pair[T, S]) = new Pair(pair.second, pair.first)



