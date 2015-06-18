val reversedFile = Source.fromFile("file.txt").getLines.toArray.reversedFile

val out = new PrintWriter("reversedFile.txt")

for (line <- reversedFile) {
      out.println(line)
      }
