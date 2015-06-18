class Square(width: Int, x: Int, y:Int) extends java.awt.Rectangle(width, width, x, y) {
    
    // 0,0 is the default cornerpoint

    def this(width: Int)
     {
         this(width, 0, 0)
     }

     def this() {
        this(0, 0, 0)
     }

}

