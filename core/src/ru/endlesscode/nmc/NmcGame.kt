package ru.endlesscode.nmc

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.FPSLogger
import ktx.app.KtxGame
import ru.endlesscode.nmc.screen.GameScreen

object NmcGame : KtxGame<Screen>() {
    val fpsLogger = FPSLogger()

    override fun create() {
        addScreen(GameScreen())
        setScreen<GameScreen>()
    }
}