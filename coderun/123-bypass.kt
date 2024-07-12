import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

data class Node(val value: Long, var left: Node?=null, var right: Node?=null)

fun insert(value: Long, node: Node?): Node {
    return if (node == null) {
        Node(value)
    } else {
        when {
            value > node.value ->
                node.right = insert(value, node.right)
            value < node.value ->
                node.left = insert(value, node.left)
            else -> {}
        }
        node
    }
}

fun dfs(node: Node?) {
    if (node != null) {
        dfs(node.left)
        println(node.value)
        dfs(node.right)
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    dfs(
        scanner.nextLine()
            .split(" ")
            .map { it.toLong() }
            .dropLast(1)
            .fold<Long, Node?>(null) { acc, n -> insert(n, acc) }
    )
    scanner.close()
    writer.close()
}
