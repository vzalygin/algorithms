import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/*
    Для текущего дня можно сделать следующее:
    1. Купить обед и получить купон (если стоит больше 100 рублей
    2. Использовать купон
 */
fun main() {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    if (n == 0) {
        println("0\n0 0")
        return
    }
    val days = Array(n) { scanner.nextInt() }
    val dp = Array(n) { Array(n+1) { Pair(Int.MAX_VALUE, listOf<Int>()) } }
    dp[0][0] = Pair(days[0], dp[0][1].second) // в первый день мы можем только купить
    if (days[0] > 100) {
        dp[0][1] = Pair(days[0], dp[0][1].second)
    }
    for (i in 1 until n) { //       дни
        for (j in 0 until n) { //  купоны
            val withCoupon = dp[i-1][j+1]
            val withoutCoupon = if (days[i] > 100 && j > 0 && dp[i-1][j-1].first <= dp[i-1][j].first) {
                dp[i-1][j-1]    // если можно заработать купон
            } else {
                dp[i-1][j]      // если не заработан (купонов столько же осталось)
            }
            if (withCoupon.first < withoutCoupon.first + days[i]) {
                dp[i][j] = Pair(withCoupon.first, withCoupon.second + listOf(i+1))
            } else {
                dp[i][j] = Pair(withoutCoupon.first + days[i], withoutCoupon.second)
            }
        }
    }
    val best = dp[n-1].mapIndexed { i, it -> Pair(it, i) }.minWith(compareBy({ it.first.first}, { -it.second }))
    val price = best.first.first
    val remains = best.second
    val used = best.first.second
    println(price)
    println("$remains ${used.size}")
    used.forEach {
        println(it)
    }
    scanner.close()
    writer.close()
}
