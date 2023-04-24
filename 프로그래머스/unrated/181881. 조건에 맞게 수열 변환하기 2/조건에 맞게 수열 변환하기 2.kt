class Solution {
    fun solution(arr: IntArray): Int {
        var change = 0;
        while (convert(arr)) change++
        return change
    }

    private fun convert(arr: IntArray): Boolean {
        var flag = false
        arr.indices.forEach {
            if (arr[it] >= 50 && arr[it] % 2 == 0) {
                arr[it] /= 2
                flag = true
            } else if (arr[it] < 50 && arr[it] % 2 == 1) {
                arr[it] = arr[it] * 2 + 1
                flag = true
            }
        }
        return flag
    }
}