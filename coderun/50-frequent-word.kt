import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main(args: Array<String>) {
    val scanner = InputStreamReader(System.`in`)
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    writer.write(
        scanner.readText().trim()
            .split("\\s+".toRegex())
            .fold(mutableMapOf<String, Int>()) { acc, s -> acc[s] = 1 + (acc[s] ?: 0); acc }
            .entries
            .sortedWith(compareBy({ -it.value }, { it.key }))
            .first()
            .key
    )
    scanner.close()
    writer.close()
}
