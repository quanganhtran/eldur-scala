object Main extends App {
  Controller()
}

object Controller {
  private var currentScreen: Screen = _

  def apply(): Unit = {
    val inn = Screen("Inn", Map())
    toScreen(inn)

    while (true) {
      toScreen(currentScreen.onCommand())
    }
  }

  def toScreen(target: Screen): Unit = {
    currentScreen = target
    currentScreen.reportScreen()
  }
}