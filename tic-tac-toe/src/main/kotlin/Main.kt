fun main() {
    val game = Game()
    game.init()

    while (!game.b_hasGameEnded) {
        game.draw()
        game.update()
    }
}