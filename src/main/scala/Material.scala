/**
  * Created by Anh on 4/17/2017.
  */
class Material(val name: String, var stock: Int) {
  def consume(amount: Int): Unit = {
    stock -= amount
  }
}

object Material {
  def apply(name: String, stock: Int = 0): Material = new Material(name, stock)
}