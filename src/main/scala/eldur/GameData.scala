package eldur

/**
  * Created by Anh on 4/17/2017.
  */
trait GameData {}

object GameData extends GameData {

  private val recipesSrc = io.Source.fromFile("assets/recipes.csv").mkString
  val recipes: Map[String, Recipe] = recipesSrc.split("\n").map(_.split(",").toList match {
    case key :: Recipe(r) => key -> r
  }).toMap

}
