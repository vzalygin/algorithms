import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashSet


fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    val set1 = HashSet<Int>()
    val set2 = HashSet<Int>()
    (0 until n).forEach { _ ->
        val num = scanner.nextInt()
        if (num !in set1) {
            set1.add(num)
        } else if (num !in set2) {
            set2.add(num)
        }
    }
    writer.write(set1.subtract(set2).size.toString())
    scanner.close()
    writer.close()
}
