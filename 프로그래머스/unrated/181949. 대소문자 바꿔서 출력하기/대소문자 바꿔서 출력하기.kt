fun main(args: Array<String>) {
    println(
        readln().toCharArray().map { 
            if (it.isUpperCase()) it.lowercaseChar() else it.uppercaseChar()
        }.joinToString("")
    )
}