package ru.endlesscode.nmc

import com.badlogic.gdx.Game
import ru.endlesscode.nmc.screen.GameScreen

//class NightMuseumCat : KtxGame<Screen>() {
//    override fun create() {
//        addScreen(GameScreen())
//        setScreen<GameScreen>()
//    }
//}

class NightMuseumCat : Game() {
    override fun create() {
        screen = GameScreen()
    }
}