open class Player() {
    var letter: String = ""
    var moves: Int = 0

    open fun type() : String {
        return "NONE"
    }

    fun move(_table: MutableList<String>) {

        while (true) {
            println("Choose your position: ")
            val input = readLine()

            if (_table.contains(input)) {
                val element = input?.toString()
                val position = _table.indexOf(element)
                _table[position] = letter
                moves++
                break
            }
            else {
                println("Invalid input, try again!")
            }
        }
    }

}