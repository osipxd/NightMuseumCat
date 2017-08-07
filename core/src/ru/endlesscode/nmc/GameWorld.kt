package ru.endlesscode.nmc

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ru.endlesscode.nmc.scene.Layer
import ru.endlesscode.nmc.scene.Scene

class GameWorld : Scene(ScreenViewport()) {
    private val textureAtlas = TextureAtlas("map/1lvl.atlas")

    // Layers
    val background: Layer
    val base: Layer

    val cat = Cat(0f, textureAtlas.findRegion("cat"))

    init {
        Gdx.input.inputProcessor = this

        // Background layer
        background = Layer()
        this.addActor(background.apply {
            val part1 = Image(textureAtlas.findRegion("part1"))
            val part2 = Image(textureAtlas.findRegion("part2")).apply {
                x = part1.right
            }

            addActor(part1)
            addActor(part2)
        })

        // Base layer
        base = Layer()
        this.addActor(base.apply {
            addActor(cat)
            y = 335f
        })
    }

    fun update(delta: Float) {
        this.act(delta)
        this.changeCamPosition(delta)
    }

    private fun changeCamPosition(delta: Float) {
        val camPos = camera.position
        val halfWidth = viewport.screenWidth / 2f
        val halfHeight = viewport.screenHeight / 2f
        val x = cat.x.coerceIn(halfWidth, background.width - halfWidth)
        val y = (base.y + cat.y).coerceIn(halfHeight, background.height - halfHeight)
        val lerp = 0.8f

        camPos.x += (x - camPos.x) * lerp * delta
        camPos.y += (y - camPos.y) * lerp * delta
    }

    fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun dispose() {
        textureAtlas.dispose()

        super.dispose()
    }

    override fun keyDown(keyCode: Int): Boolean {
        cat.velocity.x = 300f
        return true
    }

    override fun keyUp(keyCode: Int): Boolean {
        cat.velocity.x = 0f
        return true
    }
}

class GameRenderer(val world: GameWorld) {
    fun render() {
        world.camera.update()
        world.draw()
    }
}
