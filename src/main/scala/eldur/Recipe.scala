package eldur

/**
  * Created by Anh on 4/17/2017.
  */
class Recipe(
            private val recipeName: String,
            val weaponName: String,
            val tier: Int,
            private val rarity: String,
            val atk: Int,
            val mainMat: String,
            val supportMat: String
            ) {

}

object Recipe {
  def unapply(l: List[String]): Option[Recipe] = l match {
    case recipeName :: weaponName :: tier :: rarity :: atk :: mainMat :: supportMat :: Nil =>
      Some(new Recipe(recipeName, weaponName, tier.toInt, rarity, atk.toInt, mainMat, supportMat))
    case _ => None
  }
}