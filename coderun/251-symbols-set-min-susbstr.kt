import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min


fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val str = scanner.next();
    val c = setOf(*scanner.next().toCharArray().toTypedArray())
    var m = Int.MAX_VALUE

    str.indices.forEach { i ->
        val t = mutableSetOf<Char>()
        for (j in i until str.length) {
            t.add(str[j])
            if (t == c) {
                m = min(m, j - i + 1)
                break
            }
        }
    }
    if (m == Int.MAX_VALUE) {
        m = 0
    }
    writer.write(m.toString())
    scanner.close()
    writer.close()
}
