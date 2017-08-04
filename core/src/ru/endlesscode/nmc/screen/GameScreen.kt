package ru.endlesscode.nmc.screen

import com.badlogic.gdx.Gdx
import ktx.app.KtxScreen
import ru.endlesscode.nmc.GameRenderer
import ru.endlesscode.nmc.GameWorld
import ru.endlesscode.nmc.InputHandler

class GameScreen : KtxScreen {
    val world = GameWorld()
    val renderer = GameRenderer(world)
    val inputHandler = InputHandler(world.cat)

    init {
        Gdx.input.inputProcessor = inputHandler
    }

    override fun render(delta: Float) {
        world.update(delta)
        renderer.render()
    }

    override fun dispose() {
        renderer.dispose()
    }
}