import java.io.File
import java.lang.Math

fun isSafe(line : String): Boolean{
  var isDecrease = false
  var isIncrease = false
  val numbers = line.split(" ").map { it.toLong() }
  var correct = 0
  for (i in 1..(numbers.size - 1)) {
    val diff = numbers[i] - numbers[i - 1]
    if (diff > 0) isIncrease = true
    if (diff < 0) isDecrease = true
    if (Math.abs(diff) > 3 || (isIncrease && isDecrease) || diff == 0L) break
    ++correct
  }
  return correct == numbers.size - 1
}

fun firstPart(lines: List<String>): Int{
  var res: Int = 0
  for (line in lines) {
    if(isSafe(line)) ++res
  }
  return res
}


fun secondPart(lines: List<String>): Int{
  var res: Int = 0
  for (line in lines) {
    val numbers = line.split(" ").map { it.toLong() }
    var isSafeLine = false
    for(i in 0..numbers.lastIndex){
      isSafeLine = isSafe(numbers.toMutableList().apply{ removeAt(i) }.joinToString(separator=" "))
      if(isSafeLine) break
    }
    if(isSafeLine) ++res
  }
  return res
}

fun main() {
  val lines = File("./input_2.txt").readLines()
  println(firstPart(lines))
  println(secondPart(lines))
}
