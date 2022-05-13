/*
* TODO:
*  - [x] player types
*  - [x] create player
*  - [x] "your input letter - X / O"
*  - [ ] player moves
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
    var isFirstPlayerTurn:Boolean = true
    var isGame: Boolean = true

    // ------ INITIALIZE GAME ------
    fun init() {
        chooseLetter(player1, player2)
        println("------------------")
        println("${player1.type()} (${player1.letter}) vs ${player2.type()} (${player2.letter})")
        println("------------------")
    }

    // ------ UPDATE GAME ------
    fun update() {
        if (isFirstPlayerTurn) {
            player1.move(board.table as MutableList<String>)
            isGame = checkWin()
            isFirstPlayerTurn = false

        } else {
            player2.move(board.table as MutableList<String>)
            isGame = checkWin()
            isFirstPlayerTurn = true

        }

    }

    // ------ DRAW GAME ------
    fun draw() {
        board.draw()
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
            println("--------WIN---------")
            return false
        }
        if (board.table[3] == board.table[4] && board.table[4] == board.table[5]) {
            println("--------WIN---------")
            return false
        }
        if (board.table[6] == board.table[7] && board.table[7] == board.table[8]) {
            println("--------WIN---------")
            return false
        }

        // VERTICAL WINNING
        if (board.table[0] == board.table[3] && board.table[3] == board.table[6]) {
            println("--------WIN---------")
            return false
        }
        if (board.table[1] == board.table[4] && board.table[4] == board.table[7]) {
            println("--------WIN---------")
            return false
        }
        if (board.table[2] == board.table[5] && board.table[5] == board.table[8]) {
            println("--------WIN---------")
            return false
        }

        // DIAGONAL WINNING
        if (board.table[0] == board.table[4] && board.table[4] == board.table[8]) {
            println("--------WIN---------")
            return false
        }
        if (board.table[2] == board.table[4] && board.table[4] == board.table[6]) {
            println("--------WIN---------")
            return false
        }

        // NONE
        else {
            return true
        }
    }
}