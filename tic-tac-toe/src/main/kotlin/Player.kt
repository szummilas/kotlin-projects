open class Player() {
    var letter: String = ""
    var moves: Int = 0

    open fun type() : String {
        return "NONE"
    }

    open fun move(_table: MutableList<String>, _hasGameEnded: Boolean) {
        println("ERROR")
    }

}