class Solution {
    fun solution(n: Int) = Array(n) { IntArray(n) }.also {
        var row = 0
        var col = 0
        var dir = Direction.EAST
        for (num in 1..n * n) {
            it[row][col] = num
            try {
                if (it[row + dir.row][col + dir.col] != 0) dir = dir.next()
            } catch (_: ArrayIndexOutOfBoundsException) {
                dir = dir.next()
            } finally {
                row += dir.row
                col += dir.col
            }
        }
    }
}

enum class Direction(private val i: Int, val row: Int, val col: Int) {
    NORTH(0, -1, 0), EAST(1, 0, 1), SOUTH(2, 1, 0), WEST(3, 0, -1);

    fun next(): Direction = values()[(i + 1) % 4]
}