import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

fun main(args: Array<String>) {
    val reader = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.nextInt()
    val m = reader.nextInt()
    val dp = Array(n) { Array(m) { Pair(Pair(reader.nextInt(), ""), Pair(-1, -1)) } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (i == 0 && j == 0)
                continue
            if (i != 0 && (j == 0 || (dp[i-1][j].first.first > dp[i][j-1].first.first))) {
                dp[i][j] = Pair(Pair(dp[i][j].first.first + dp[i-1][j].first.first, "D"), Pair(i-1, j))
            } else {
                dp[i][j] = Pair(Pair(dp[i][j].first.first + dp[i][j-1].first.first, "R"), Pair(i, j-1))
            }
        }
    }

    val way = mutableListOf<String>()
    val sum = dp[n-1][m-1]
    var i = n-1
    var j = m-1
    while (i >= 0 && j >= 0) {
        val (x, y) = dp[i][j]
        val (_, step) = x
        val (prevI, prevJ) = y
        way.add(step)
        i = prevI
        j = prevJ
    }
    val wayStr = way.dropLast(0).asReversed().fold("") { acc, step -> "$acc $step" }

    writer.write("${sum.first.first}\n")
    writer.write(wayStr.strip())
    reader.close()
    writer.close()
}
