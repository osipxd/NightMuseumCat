package ru.endlesscode.nmc

import com.badlogic.gdx.Screen
import ktx.app.KtxGame
import ru.endlesscode.nmc.screen.GameScreen

class NightMuseumCat : KtxGame<Screen>(fixedTimeStep = 1f / 120f) {
    override fun create() {
        addScreen(GameScreen())
        setScreen<GameScreen>()
    }
}