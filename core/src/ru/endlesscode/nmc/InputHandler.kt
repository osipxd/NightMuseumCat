package ru.endlesscode.nmc

import com.badlogic.gdx.Gdx
import ktx.app.KtxInputAdapter

class InputHandler(val cat: Cat) : KtxInputAdapter {
    override fun keyDown(keycode: Int): Boolean {
        println(keycode)
        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        return true
    }
}