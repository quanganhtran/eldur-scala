/**
  * Created by ado on 17/04/2017.
  */
class Screen(val name: String, connections: Map[String, Screen]) {

  def reportScreen(): Unit = println(s"This is $name.")

  def onCommand(): Screen = {
    println("Enter a command: ")
    val input = io.StdIn.readLine()
    val connection = interpret(input)
    connections.get(connection) match {
      case Some(nextScreen) => nextScreen
      case None => onCommand()
    }
  }

  def interpret(input: String): String = input match {
    case "where" =>
      reportScreen()
      ""
    case "quit" =>
      println("Thanks for playing!")
      sys.exit()
    case other => other
  }
}

object Screen {
  def apply(name: String, connections: Map[String, Screen]): Screen = new Screen(name, connections)
}