package ru.endlesscode.nmc

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Actor
import ktx.math.plus
import ktx.math.times



class Cat(x: Float, private val texture: TextureRegion): Actor() {
    val velocity = Vector2(100f, 0f)
    val acceleration = Vector2()

    init {
        this.x = x
        this.y = 0f
        this.width = 64f
        this.height = 80f
    }

    override fun act(delta: Float) {
        velocity + (acceleration.cpy() * delta)

        if (velocity.x > 400) {
            velocity.x = 400f
        } else if (velocity.x < 0) {
            velocity.x = 0f
        }

        x += velocity.x * delta
        y += velocity.y * delta

        if (x >= stage.width) {
            x = 0f - width
        }
    }

    override fun draw(batch: Batch, parentAlpha: Float) {
        batch.draw(texture, x, y, width, height)
    }
}