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
    val b = Array(n) { scanner.nextInt() }
    val m = scanner.nextInt()
    val d = Array(n) { 0 }
    (0 until m).forEach { _ ->
        d[scanner.nextInt()-1] += 1
    }
    (0 until n).forEach { i ->
        println(
            if(b[i] < d[i]) {
                "YES"
            } else {
                "NO"
            }
        )
    }

    scanner.close()
    writer.close()
}
