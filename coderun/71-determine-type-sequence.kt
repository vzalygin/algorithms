import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val l = mutableListOf<Int>()
    while (scanner.hasNextInt()) {
        val n = scanner.nextInt()
        if (n == -2_000_000_000) {
            break
        }
        l.add(n)
    }
    val ll = l.zip(l.slice(1 until l.size))
    if (ll.all { it.first == it.second }) {
        println("CONSTANT")
    } else if (ll.all { it.first < it.second }) {
        println("ASCENDING")
    } else if (ll.all { it.first <= it.second }) {
        println("WEAKLY ASCENDING")
    } else if (ll.all { it.first > it.second }) {
        println("DESCENDING")
    } else if (ll.all { it.first >= it.second }) {
        println("WEAKLY DESCENDING")
    } else {
        println("RANDOM")
    }
    scanner.close()
    writer.close()
}
