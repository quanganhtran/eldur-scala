package eldur

/**
  * Created by Anh on 4/17/2017.
  */
class GameData {}

object GameData extends GameData {

  val materials = Map(
    "copper" -> Material("Copper", 100),
    "iron" -> Material("Iron", 100),
    "silver" -> Material("Silver", 100)
  )

  private val recipesSrc = io.Source.fromFile("assets/recipes.csv").mkString
  val recipes: Map[String, Recipe] = recipesSrc.split("\n").map(_.split(",").toList match {
    case key :: Recipe(r) => key -> r
  }).toMap

}
