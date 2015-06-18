trait CryptoLogger {

val offset: Int = 3

def log(msg: String) {
 for (char <- msg) {

        var cipherChar = (char+ offset).toChar
        if (cipherChar.toUpper > 'Z')
            cipherChar = (cipherChar - 26).toChar
        print( cipherChar)
    }
}

}