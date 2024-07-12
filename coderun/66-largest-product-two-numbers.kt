import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val a = scanner.nextLine().trim().split(" ").map { it.toLong() }
    var lastMax = a[0]
    var lastMin = a[0]
    var maxMul: Long? = null
    var maxPair = Pair(0L, 0L)
    a.slice(1 until a.size).forEach { n ->
        if (maxMul == null || n * lastMax > maxMul!!) {
            maxMul = n * lastMax
            maxPair = Pair(n, lastMax)
        }
        if (maxMul == null || n * lastMin > maxMul!!) {
            maxMul = n * lastMin
            maxPair = Pair(n, lastMin)
        }
        lastMax = max(lastMax, n)
        lastMin = min(lastMin, n)
    }
    println(maxPair.toList().sorted().joinToString(" ") { it.toString() })
    scanner.close()
    writer.close()
}
