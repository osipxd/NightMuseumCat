package ru.endlesscode.nmc

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Actor
import ktx.math.*

class Cat(x: Float) : Actor() {
    val position = Vector2(x, 0f)
    val velocity = Vector2()
    val acceleration = Vector2()
    val width = 64
    val height = 80

    fun update(delta: Float) {
        velocity + (acceleration.cpy() * delta)

        if (velocity.x > 200) {
            velocity.x = 200f
        }

        position + (velocity.cpy() * delta)
    }
}