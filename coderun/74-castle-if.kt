import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val (a, b, _) = listOf(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()).sorted()
    val (d, e) = listOf(scanner.nextInt(), scanner.nextInt()).sorted()
    println(
        if (a <= d && b <= e) {
            "YES"
        } else {
            "NO"
        }
    )
    scanner.close()
    writer.close()
}
