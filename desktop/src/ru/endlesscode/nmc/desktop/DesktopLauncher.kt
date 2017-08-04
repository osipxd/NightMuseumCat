package ru.endlesscode.nmc.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import ru.endlesscode.nmc.NightMuseumCat

object DesktopLauncher {
    @JvmStatic fun main(arg: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration()
        val displayMode = Lwjgl3ApplicationConfiguration.getDisplayMode()
//        config.setFullscreenMode(displayMode)
        config.setWindowedMode(displayMode.width / 2, displayMode.height / 2)
//        config.setDecorated(false)
        config.setIdleFPS(60)
        Lwjgl3Application(NightMuseumCat(), config)
    }
}