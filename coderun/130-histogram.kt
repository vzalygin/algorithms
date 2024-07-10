import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    var text = ""
    while (scanner.hasNext()) {
        text += scanner.next()
    }
    val map = mutableMapOf<Char, Int>()
    text.forEach { map[it] = (map[it] ?: 0) + 1 }
    val res = map.entries.sortedBy { it.key }.map { arrayOf(it.key, *"#".repeat(it.value).toCharArray().toTypedArray()) }.toTypedArray()
    val n = res.size
    val m = res.maxBy { it.size }.size
    val a = Array(m) { i ->
        Array(n) { j ->
            if(res[j].size > m-1-i) {
                res[j][m-1-i]
            } else {
                ' '
            }
        }
    }
    println(a.joinToString(separator = "\n") {
        row -> row.joinToString(separator = "") {
            it.toString()
        }
    })
    scanner.close()
    writer.close()
}
