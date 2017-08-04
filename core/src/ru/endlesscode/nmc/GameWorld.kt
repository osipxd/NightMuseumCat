package ru.endlesscode.nmc

class GameWorld {
    val cat = Cat(0f)

    fun update(delta: Float) {
        cat.update(delta)
    }
}