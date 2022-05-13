class HumanPlayer : Player() {
    override fun type(): String {
        return "HUMAN"
    }

    override fun move(_table: MutableList<String>, _hasGameEnded: Boolean) {
        while (!_hasGameEnded) {
            print("Choose your position: ")
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