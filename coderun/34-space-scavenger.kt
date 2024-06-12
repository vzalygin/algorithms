import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
    Первая ось -- параметр
    Вторая ось --
 */

fun Char.mapToInt(): Int {
    return when(this) {
        'N' -> 0
        'S' -> 1
        'W' -> 2
        'E' -> 3
        'U' -> 4
        'D' -> 5
        else -> -1
    }
}

fun String.foo(): IntArray {
    val table = IntArray(6)
    this.forEach { c ->
        table[c.mapToInt()] += 1
    }
    return table
}

fun main() {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val a = Array(6) { scanner.nextLine().foo() }
    val command = scanner.next()
    val num = scanner.nextInt()
    val dp = Array(num) { IntArray(6) { 1 } }
    for (i in 1 until num) {
        for (j in 0 until 6) {
            dp[i][j] = 1 +
                    (0 until 6)
                        .map { t -> dp[i-1][t] * a[j][t] }
                        .fold(0) { acc, t -> acc + t }
        }
    }
    println(dp[num-1][command.toCharArray()[0].mapToInt()])
}
