class Board {
    var table = listOf<String>("0", "1", "2", "3", "4", "5", "6", "7", "8")

    fun draw() {
        println()
        println("     |     |      ")
        println("  ${table[0]}  |  ${table[1]}  |  ${table[2]}")
        println("_____|_____|_____ ")
        println("     |     |      ")
        println("  ${table[3]}  |  ${table[4]}  |  ${table[5]}")
        println("_____|_____|_____ ")
        println("     |     |      ")
        println("  ${table[6]}  |  ${table[7]}  |  ${table[8]}")
        println("     |     |      ")
        println()
    }
}