import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

class Node(val value: Int, val left: Node?=null, val right: Node?=null);

fun append(n: Int, node: Node?): Node {
    return if (node == null) {
        Node(n)
    } else if (n < node.value) {
        Node(
            node.value,
            append(n, node.left),
            node.right
        )
    } else if (n > node.value) {
        Node(
            node.value,
            node.left,
            append(n, node.right)
        )
    } else {
        node
    }
}

fun height(node: Node?): Int {
    return if (node != null) {
        1 + max(height(node.left), height(node.right))
    } else {
        0
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    var tree: Node? = null
    while (scanner.nextInt().also { if(it != 0) { tree = append(it, tree) } } != 0) { }
    writer.write(height(tree).toString())
    scanner.close()
    writer.close()
}
