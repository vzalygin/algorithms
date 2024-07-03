import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    val r = scanner.nextInt()
    val a = Array(n) { scanner.nextInt() }
    var start = 0
    var end = 0
    var sum: Long = 0

    while (start < a.size) {
        while (end < a.size && a[end] - a[start] <= r) {
            end += 1
        }
        sum += (a.size - end).toLong()
        start += 1
    }
    writer.write(sum.toString())
    scanner.close()
    writer.close()
}
