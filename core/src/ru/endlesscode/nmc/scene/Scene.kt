package ru.endlesscode.nmc.scene

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.Viewport

open class Scene(viewport: Viewport) : Stage(viewport)

class Layer : Group() {
    override fun addActor(actor: Actor) {
        width = maxOf(width, actor.right)
        height = maxOf(height, actor.top)

        super.addActor(actor)
    }
}
