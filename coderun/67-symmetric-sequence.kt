import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(BufferedReader(InputStreamReader(System.`in`)))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = scanner.nextInt()
    val a = List(n) { scanner.nextInt() }
    var m = Int.MAX_VALUE
    var mA = listOf<Int>()
    // поставить на середину (ближайший текущий/следующий после середины)
    // посмотреть, насколько симметрично
    // если симметрично до правого конца, то можно дополнить
    // двигаем середину до правого конца
    if (n == 1) {
        println(0)
        return
    }
    for (i in (a.size / 2) until a.size) {
        var s = 0
        while (i + s < a.size && a[i - s] == a[i + s]) {
            s += 1
        }
        s -= 1
        // дошли до правого конца
        if (i + s == a.size - 1) {
            if (m > i - s) {
                m = i - s
                mA = a.subList(0, i - s).asReversed()
            }
        }
        // если центр между элементами
        // i -- указатель на правый элемент
        s = 0
        while (i + s < a.size && i-s-1 >= 0 && a[i-s-1] == a[i+s]) {
            s += 1
        }
        if (i + s == a.size) {
            if (m > i - s) {
                m = i - s
                mA = a.subList(0, i - s).asReversed()
            }
        }
    }
    writer.write("$m\n${mA.joinToString(" ") { it.toString() }}\n")
    scanner.close()
    writer.close()
}
