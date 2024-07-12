import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val deque = ArrayDeque<Long>()
    while (scanner.hasNextLine()) {
        val command = scanner.nextLine().split(" ")
        when (command[0]) {
            "push" -> {
                println("ok")
                deque.addLast(command[1].toLong())
            }
            "pop" -> {
                if (deque.isEmpty()) {
                    println("error")
                } else {
                    println(deque.pollLast())
                }
            }
            "back" -> {
                if (deque.isEmpty()) {
                    println("error")
                } else {
                    println(deque.peekLast())
                }
            }
            "size" -> {
                println(deque.size)
            }
            "clear" -> {
                println("ok")
                deque.clear()
            }
            "exit" -> {
                println("bye")
                return
            }
        }
    }
    scanner.close()
    writer.close()
}
