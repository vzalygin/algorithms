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
        .sortedWith(compareBy { it.second })
        .associateBy { it.first }
        .entries.sumOf { it.value.second.toLong() }
    println(a)
    scanner.close()
    writer.close()
}
