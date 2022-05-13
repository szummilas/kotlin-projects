fun main() {
    val game = Game()
    game.init()

    while (true) {
        game.draw()
        game.update()
    }
}