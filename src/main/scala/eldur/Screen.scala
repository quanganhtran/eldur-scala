package eldur

/**
  * Created by ado on 17/04/2017.
  */
class Screen(val name: String, val connections: Map[String, Screen] = Map(), protected var unlocked: Boolean = true)
            (implicit private val gameData: GameData) {

  def interpret(input: String): String = input match {
    case "where" =>
      reportScreen()
      ""
    case "quit" =>
      println("Thanks for playing!")
      sys.exit()
    case other => other
  }

  def reportScreen(): Unit = println(s"This is $name.")

  def runScreen(): Screen = {
    println("========================================")
    println("\u001B[34mEnter a command: \u001B[0m")
    val input = io.StdIn.readLine()
    println("--------------------")

    val connection = interpret(input)
    connections.get(connection) match {
      case Some(nextScreen) =>
        if (nextScreen.unlocked) nextScreen
        else {
          println("You cannot go to that area yet.")
          runScreen()
        }
      case None =>
        if (connection != "") println("Invalid command. Please try again")
        runScreen()
    }
  }

  def unlock(): Unit = unlocked = true
}

object Screen {
  def apply(name: String, connections: Map[String, Screen] = Map(), unlocked: Boolean = true)
           (implicit gameData: GameData): Screen =
    new Screen(name, connections, unlocked)
}