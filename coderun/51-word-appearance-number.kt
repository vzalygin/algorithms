import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(File("input.txt").reader()))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val map = mutableMapOf<String, Int>()
    while (scanner.hasNext()) {
        val next = scanner.next()
        val count = map[next] ?: 0
        writer.write("$count ")
        map[next] = count + 1
    }
    scanner.close()
    writer.close()
}
