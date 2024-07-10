import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    val a = Array(n) { scanner.nextInt() }
    val m = scanner.nextInt()
    println(a.minBy { abs(it - m) })
    scanner.close()
    writer.close()
}
