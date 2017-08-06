package ru.endlesscode.nmc.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ru.endlesscode.nmc.Cat

class GameScreen : KtxScreen {
    val stage = Stage(ScreenViewport())
    private val textureAtlas = TextureAtlas("map/1lvl.atlas")

    init {
        Gdx.input.inputProcessor = stage
        val cat = Cat(0f, textureAtlas.findRegion("cat"))
        stage.addActor(cat)
    }

    override fun render(delta: Float) {
        clearScreen(0f, 0f, 0f)
        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height)
    }

    override fun dispose() {
        stage.dispose()
        textureAtlas.dispose()
    }
}