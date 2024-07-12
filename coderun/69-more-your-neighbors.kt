import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    println(
        scanner.nextLine().split(" ")
            .map { it.toInt() }
            .let {
                it.zip(
                    it.slice(1 until it.size)
                        .zip(
                            it.slice(2 until it.size)
                        )
                )
            }.filter {
                it.first < it.second.first &&
                it.second.first > it.second.second
            }.size
    )
    scanner.close()
    writer.close()
}
