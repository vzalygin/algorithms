import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.nextInt()
    val m = reader.nextInt()
    val dp = Array(n) { Array(m) { reader.nextInt() } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (i == 0 && j == 0)
                continue
            if (i != 0 && (j == 0 || (dp[i-1][j] < dp[i][j-1]))) {
                dp[i][j] = dp[i][j] + dp[i-1][j]
            } else {
                dp[i][j] = dp[i][j] + dp[i][j-1]
            }
        }
    }
    val sum = dp[n-1][m-1]
    writer.write("$sum")
    reader.close()
    writer.close()
}
