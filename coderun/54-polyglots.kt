import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextLine().toInt()
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val l = scanner.nextLine().toInt()
        for (j in 0 until l) {
            val lang = scanner.nextLine()
            map[lang] = (map[lang] ?: 0) + 1
        }
    }
    val all = map.entries.filter { it.value == n }.map { it.key }
    val any = map.map { it.key }
    writer.write("${all.size}\n${all.joinToString(separator = "\n") { it }}\n")
    writer.write("${any.size}\n${any.joinToString(separator = "\n") { it }}\n")
    scanner.close()
    writer.close()
}
