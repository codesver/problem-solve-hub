fun main(args: Array<String>) {
    val num = readln().toInt()
    println("$num is ${if (num % 2 == 0) "even" else "odd"}")
}