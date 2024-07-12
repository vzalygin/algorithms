import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    val a = Array(n) { Pair(scanner.nextInt(), scanner.nextInt()) }
    println("${a.minBy { it.first }.first} ${a.minBy { it.second }.second } ${a.maxBy { it.first }.first} ${a.maxBy { it.second }.second}")
    scanner.close()
    writer.close()
}
