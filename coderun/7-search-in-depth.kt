import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val vertexAmount = scanner.nextInt()
    val edgeAmount = scanner.nextInt()
    val neighbors = Array(vertexAmount+1) { mutableSetOf<Int>() }
    (0 until edgeAmount).forEach { _ ->
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        neighbors[a].add(b)
        neighbors[b].add(a)
    }
    val queue = ArrayDeque<Int>()
    queue.add(1)
    val visited = mutableSetOf<Int>()
    visited.add(1)
    while (!queue.isEmpty()) {
        val vertex = queue.pollFirst()!!
        neighbors[vertex].forEach { neighbor ->
            if (!visited.contains(neighbor)) {
                visited.add(neighbor)
                queue.add(neighbor)
            }
        }
    }
    writer.write("${visited.size}\n")
    writer.write(visited.toList().sorted().joinToString(separator = " ") { it.toString() })
    scanner.close()
    writer.close()
}