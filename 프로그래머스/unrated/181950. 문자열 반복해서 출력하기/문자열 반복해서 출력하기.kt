import java.util.StringTokenizer

fun main(args: Array<String>) {
    val tokenizer = StringTokenizer(readln())
    println(tokenizer.nextToken().repeat(tokenizer.nextToken().toInt()))
}