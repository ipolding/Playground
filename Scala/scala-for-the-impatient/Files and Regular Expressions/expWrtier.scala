import java.io.PrintWriter

object ExponentTable {

    def powersOfTwo(filename: String, maxExp: Int) = {
        
        val writer = new PrintWriter(filename)
        val x = BigInt(2)

        for (i <- 0 to maxExp) {
            val y = x.pow(i)
            writer.println(y.toString.padTo(10 , ' ') + (1.0/y.doubleValue))
        }
        writer.close()


    }

    


}