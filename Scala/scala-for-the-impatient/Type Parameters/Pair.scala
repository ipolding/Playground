class Pair[T, S](first : T, second: S) {

    def swap : Pair[S, T] = new Pair(second, first)     

}