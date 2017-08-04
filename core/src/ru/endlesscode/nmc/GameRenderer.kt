package ru.endlesscode.nmc

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.utils.Disposable
import ktx.app.use

class GameRenderer(val world: GameWorld) : Disposable {
    private val camera = OrthographicCamera()
    private val batch = SpriteBatch()
    private val textureAtlas = TextureAtlas("map/1lvl.atlas")
    private val cat = textureAtlas.createSprite("cat")

    init {
        camera.setToOrtho(false)
        batch.projectionMatrix = camera.combined
    }

    fun render() {
        camera.update()

        batch.use {
            cat.setPosition(world.cat.getX(), world.cat.getY())
            cat.draw(batch)
        }
    }

    override fun dispose() {
        batch.dispose()
    }
}