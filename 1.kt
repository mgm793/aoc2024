import java.io.File
import java.lang.Math

fun firstPart(lines: List<String>): Long{
  val (left, right) = lines.map{
    line -> 
    val first = line.substringBefore(" ").toLong()
    val second = line.substringAfterLast(" ").toLong()
    first to second
  }.unzip();
  return left.sorted().zip(right.sorted()).map{(first, second) -> Math.abs(first - second)}.sum()
}

fun secondPart(lines: List<String>): Long{
  val (left, right) = lines.map{
    line -> 
    val first = line.substringBefore(" ").toLong()
    val second = line.substringAfterLast(" ").toLong()
    first to second
  }.unzip();

  val frequencies = right.groupingBy{it}.eachCount()
  return left.fold(0L){
    acc, value -> acc + value * frequencies.getOrDefault(value, 0)
  }
  
}
fun main(){
  val lines = File("./input_1.txt").readLines()
  println(firstPart(lines))
  println(secondPart(lines))
}

