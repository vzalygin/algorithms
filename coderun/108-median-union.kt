import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun merge(a: Array<Int>, b: Array<Int>): Int {
    var i = 0
    var j = 0
    var last = 0
    while (i + j < a.size) {
        if (a[i] < b[j]) {
            last = a[i]
            i += 1
        } else {
            last = b[j]
            j += 1
        }
    }
    return last
}

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    val l = scanner.nextInt()
    val aa = Array(n) { Array(l) { scanner.nextInt() } }
    for (i in 0 until n) {
        for (j in i+1 until n) {
            println(merge(aa[i], aa[j]))
        }
    }
    scanner.close()
    writer.close()
}
