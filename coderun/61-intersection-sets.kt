import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    println(
        scanner.nextLine().split(" ").map { it.toInt() }.toSet()
            .intersect(
                scanner.nextLine().split(" ").map { it.toInt() }.toSet()
            )
            .toList().sortedBy { it }.joinToString(separator = " ") { it.toString() }
    )
    scanner.close()
    writer.close()
}
