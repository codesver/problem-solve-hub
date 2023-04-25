class Solution {
    fun solution(binomial: String) = binomial.split(" * ")
        .map { it.replace("+ ", "+").replace("- ", "-").split(" ").sumOf { num -> num.toInt() } }
        .fold(1) { acc, i -> acc * i }
}