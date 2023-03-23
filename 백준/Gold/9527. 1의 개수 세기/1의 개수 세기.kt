import kotlin.math.max
import kotlin.math.pow

class Main(private val result: StringBuilder = StringBuilder()) {

    fun solve() {
        val (from, to) = readln().split(" ").map { it.toLong() }
        result.append(count(to) - count(from - 1))
    }

    private fun count(num: Long): Long {
        var count: Long = 0
        val len = num.toString(2).length
        for (i in 1..len) {
            val ca = (num + 1) / 2.0.pow(i).toLong() * 2.0.pow(i - 1).toLong()
            val cb = (num + 1) % 2.0.pow(i).toLong() - 2.0.pow(i - 1).toLong()
            count += ca + max(cb, 0)
        }
        return count
    }

    fun finish(): Unit = with(System.out.bufferedWriter()) {
        write(result.toString())
        flush()
        close()
    }
}

fun main() {
    val main = Main()
    main.solve()
    main.finish()
}