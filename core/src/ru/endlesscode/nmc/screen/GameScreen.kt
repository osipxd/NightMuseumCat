package ru.endlesscode.nmc.screen


import ktx.app.KtxScreen
import ru.endlesscode.nmc.GameRenderer
import ru.endlesscode.nmc.GameWorld
import ru.endlesscode.nmc.NmcGame

class GameScreen : KtxScreen {
    val world = GameWorld()
    val renderer = GameRenderer(world)

    override fun render(delta: Float) {
        world.update(delta)
        renderer.render()

        NmcGame.fpsLogger.log()
    }

    override fun resize(width: Int, height: Int) {
        world.resize(width, height)
    }

    override fun dispose() {
        world.dispose()
    }
}
