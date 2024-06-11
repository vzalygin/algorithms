import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

fun main() {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val n = scanner.nextInt()
    var input = Array(n) { scanner.nextInt() }.toList()
    val sorted = input.sortedBy { -it }
    input = input.drop(input.mapIndexed { i, it -> Pair(i, it) }.maxWith(compareBy({it.second}, {-it.first})).first+1)
    if (input.size < 2) {
        println(0)
        return
    }
    var maxNum = Int.MIN_VALUE
    for (i in 0 until input.size-1) {
        if (input[i] % 10 == 5 && input[i] > input[i+1]) {
            maxNum = max(maxNum, input[i])
        }
    }
    for (i in sorted.indices) {
        if (sorted[i] == maxNum) {
            println(i+1)
            return
        }
    }
    println(0)
}
