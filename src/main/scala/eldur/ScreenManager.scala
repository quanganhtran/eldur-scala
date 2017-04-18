package eldur

/**
  * Created by Anh on 4/18/2017.
  */
object ScreenManager {

  implicit val gameData: GameData = GameData

  def apply(): Unit = {
    val startingScreen = Screen("Town", Map())
    toScreen(startingScreen.runScreen())
  }

  def toScreen(target: Screen): Screen = {
    target.reportScreen()
    toScreen(target.runScreen())
  }
}
