import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    println(Array(n) { Pair(scanner.nextInt(), scanner.nextInt()) }.sortedBy { it.second }.associateBy { it.first }.size)
    scanner.close()
    writer.close()
}
