package funsets

object Main extends App {

  import FunSets._

  println(contains(singletonSet(1), 1))

  val set1 = singletonSet(1)
  val set2 = singletonSet(2)
  println(union(set1, set2)(2))

  println(intersect(set1, set2)(1))
}
