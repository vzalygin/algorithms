import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    val syns = mutableMapOf<String, String>()
    (0 until n).forEach { _ ->
        val first = scanner.next()
        val second = scanner.next()
        syns[first] = second
        syns[second] = first
    }
    writer.write(syns[scanner.next()]!!)
    scanner.close()
    writer.close()
}
