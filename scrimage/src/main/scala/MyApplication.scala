
object Main extends App {

  Console.println("Hello World!")

  Image(in).scale(0.5, Bicubic).write(out) // Png is default

}
