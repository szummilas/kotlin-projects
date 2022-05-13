/*
* TODO:
*  - [x] player types
*  - [x] create player
*  - [x] "your input letter - X / O"
*  - [x] player moves
*  - [x] conditions of winning
*  - [ ] player vs player
*  - [ ] random player
*  - [ ] algorithms for AIPlayer
*       - [ ] minimax
*       - [ ] alfa-beta
 */

class Game {
    val board = Board()
    val player1 = createPlayer(typeOfPlayer())
    val player2 = createPlayer(typeOfPlayer())
    var b_isFirstPlayerTurn:Boolean = true
    var b_hasGameEnded: Boolean = false

    // ------ INITIALIZE GAME ------
    fun init() {
        chooseLetter(player1, player2)
        println("------------------")
        println("${player1.type()} (${player1.letter}) vs ${player2.type()} (${player2.letter})")
        println("------------------")
    }

    // ------ UPDATE GAME ------
    fun update() {
        if (b_isFirstPlayerTurn) {
            player1.move(board.table as MutableList<String>, b_hasGameEnded)
            b_hasGameEnded = checkWin()
            b_isFirstPlayerTurn = false
        } else {
            player2.move(board.table as MutableList<String>, b_hasGameEnded)
            b_hasGameEnded = checkWin()
            b_isFirstPlayerTurn = true
        }
    }

    // ------ DRAW GAME ------
    fun draw() {
        if (!b_hasGameEnded) {
            board.draw()
        }
    }

    // ------ OTHER ------
    /**
     * choosing one of given player types for each player
     */
    private fun typeOfPlayer(): String {
        val playerTypesList = listOf<String>("H", "R", "A")

        while (true) {
            println("Choose type of player: H -Human, R -Random, A -AIPlayer")
            print("Your input: ")

            val input = readLine()?.uppercase()

            if (playerTypesList.contains(input)) {
                println("You've entered: $input")
                return input.toString()
            } else {
                println("Invalid input, choose again!")
            }
        }
    }

    /**
     * choosing letter for each of players
     */
    private fun chooseLetter(player1: Player, player2: Player) {
        val letterList = listOf<String>("X", "O")

        // check if player already has letter
        while (true) {
            if (player1.letter == "") {
                while (true) {
                    print("Choose your letter (X/O): ")

                    val input = readLine()?.uppercase()

                    if (letterList.contains(input)) {
                        println("Your letter: $input")
                        player1.letter = input.toString()
                        break
                    } else {
                        println("Invalid input, try again!")
                    }
                }
            } else {
                if (player1.letter == "X") {
                    player2.letter = "O"
                    break
                }
                if (player1.letter == "O") {
                    player2.letter = "X"
                    break
                }
            }
        }
    }

    /**
     * creating player of specific type
     */
    private fun createPlayer(type: String): Player {
        return when(type) {
            "H" -> HumanPlayer()
            "R" -> RandomPlayer()
            "A" -> AIPlayer()
            else -> Player()
        }
    }

    /**
     * check conditions of winning
     */
    private fun checkWin():Boolean {
        /*
        * 0 1 2
        * 3 4 5
        * 6 7 8
         */

        // HORIZONTAL WINNING
        if (board.table[0] == board.table[1] && board.table[1] == board.table[2]) {
            whichPlayerWon()
            return true
        }
        if (board.table[3] == board.table[4] && board.table[4] == board.table[5]) {
            whichPlayerWon()
            return true
        }
        if (board.table[6] == board.table[7] && board.table[7] == board.table[8]) {
            whichPlayerWon()
            return true
        }

        // VERTICAL WINNING
        if (board.table[0] == board.table[3] && board.table[3] == board.table[6]) {
            whichPlayerWon()
            return true
        }
        if (board.table[1] == board.table[4] && board.table[4] == board.table[7]) {
            whichPlayerWon()
            return true
        }
        if (board.table[2] == board.table[5] && board.table[5] == board.table[8]) {
            whichPlayerWon()
            return true
        }

        // DIAGONAL WINNING
        if (board.table[0] == board.table[4] && board.table[4] == board.table[8]) {
            whichPlayerWon()
            return true
        }
        if (board.table[2] == board.table[4] && board.table[4] == board.table[6]) {
            whichPlayerWon()
            return true
        }

        // NONE
        else {
            return false
        }
    }

    /**
     * printing which player won
     */
    private fun whichPlayerWon() {
        if (b_isFirstPlayerTurn) {
            println()
            println("------------------")
            println("FIRST PLAYER (${player1.type()}) WON")
            println("------------------")
            println()
        } else {
            println()
            println("------------------")
            println("SECOND PLAYER (${player2.type()}) WON")
            println("------------------")
            println()
        }
    }
}