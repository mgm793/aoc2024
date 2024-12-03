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


fun secondPart(text: String): Long{
  val regex = Regex("""mul\(\d+,\d+\)|do\(\)|don't\(\)""")
  val matches = regex.findAll(text)
  var isEnabled = true
  return matches.fold(0L){acc: Long, match ->
    val value = match.value
    when(value){
      "don't()" -> {
        isEnabled = false
        acc
      }
      "do()" -> {
        isEnabled = true
        acc
      }
      else -> {
        var newValue = acc
        if(isEnabled) {
          val values = value.replace("""mul\(|\)""".toRegex(), "").split(",")
          newValue += (values[0].toLong() * values[1].toLong())
        }
        newValue
      }
    } 
  }
}

fun main(){
  val text = File("./input_3.txt").readText()
  println(firstPart(text))
  println(secondPart(text))
}