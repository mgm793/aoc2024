import java.io.File

fun firstPart(text: String): Long{
  val regex = Regex("""mul\((\d+),(\d+)\)""")
  val matches = regex.findAll(text)
  return matches.fold(0L){  acc, match ->
    val first = match.groupValues[1].toLong();
    val second = match.groupValues[2].toLong();
    acc + (first * second)
  }
}

fun main(){
  val text = File("./input_3.txt").readText()
  println(firstPart(text))

}