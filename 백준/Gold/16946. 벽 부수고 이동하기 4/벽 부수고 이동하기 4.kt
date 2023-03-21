import java.awt.Point
import java.util.*

class Main(private val result: StringBuilder = StringBuilder()) {

    private val moves = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))

    private var row: Int = 0
    private var col: Int = 0
    private lateinit var map: Array<IntArray>

    fun solve() {
        input()
        searchPass()
        output()
    }

    private fun searchPass(): Unit {
        for (r in 1..row) 
            for (c in 1..col) 
                if (map[r][c] == 0) countPass(r, c)
    }

    private fun countPass(r: Int, c: Int) {
        val walls = mutableSetOf<Point>()

        var count = 1
        map[r][c] = -1
        val zeros: Queue<Point> = LinkedList(Collections.singleton(Point(r, c)))
        while (!zeros.isEmpty()) {
            val zero = zeros.poll()
            for (move in moves) {
                val row = zero.x + move[0]
                val col = zero.y + move[1]
                if (map[row][col] > 0) walls.add(Point(row, col))
                else if (map[row][col] == 0) {
                    count++
                    map[row][col] = -1
                    zeros.offer(Point(row, col))
                }
            }
        }

        for (wall in walls) map[wall.x][wall.y] += count
        walls.clear()
    }

    private fun input(): Unit = with(System.`in`.bufferedReader()) {
        val tokenizer = StringTokenizer(readLine())
        row = tokenizer.nextToken().toInt()
        col = tokenizer.nextToken().toInt()
        map = Array(row + 2) { IntArray(col + 2) { 1 } }
        for (r in 1..row)
            map[r] = ("1" + readLine() + "1").chars().map(Character::getNumericValue).toArray()
    }

    private fun output(): Unit = with(System.out.bufferedWriter()) {
        for (r in 1..row) {
            for (c in 1..col) result.append(if (map[r][c] < 0) 0 else map[r][c] % 10)
            result.append('\n')
        }
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