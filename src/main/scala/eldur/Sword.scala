package eldur

/**
  * Created by Anh on 4/17/2017.
  */
class Sword(
           var _name: String,
           private val tier: Int,
           val atk: Int,
           private var socket: Int = 1,
           var refinement: String = ""
           ) {
  def name: String = _name

  def useSocket(): Unit = {
    socket -= 1
  }

  def addSocketName(s: String): Unit = {
    _name += " " + s
  }
}
