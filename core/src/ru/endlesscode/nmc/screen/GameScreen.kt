package ru.endlesscode.nmc.screen


import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ktx.app.KtxScreen
import ru.endlesscode.nmc.Cat
import ru.endlesscode.nmc.NmcGame

class GameScreen : KtxScreen {
    val stage = Stage(ScreenViewport())
    private val textureAtlas = TextureAtlas("map/1lvl.atlas")

    init {
        Gdx.input.inputProcessor = stage
        val cat = Cat(0f, textureAtlas.findRegion("cat"))
        stage.addActor(cat)
    }

    override fun render(delta: Float) {
        stage.act(delta)
        stage.draw()
        NmcGame.fpsLogger.log()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun dispose() {
        stage.dispose()
        textureAtlas.dispose()
    }
}