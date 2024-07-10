import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val text = mutableListOf<String>()
    while (scanner.hasNext()) {
        text += scanner.next()
    }
    println(
        text.toSet().size
    )
    scanner.close()
    writer.close()
}
