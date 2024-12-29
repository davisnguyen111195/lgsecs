package io.github.lgsecs.views

import com.badlogic.gdx.Screen
import io.github.lgsecs.Main
import io.github.lgsecs.Main.Companion.assetManager
import io.github.lgsecs.views.lgsPanel.LGSPanelScreen

class IntroScreen(private val main: Main) : Screen {

    override fun show() {
        assetManager.queueAddSkin()
        assetManager.manager.finishLoading()
        if(assetManager.manager.update()){
            main.screen = LGSPanelScreen()
        }
    }

    override fun render(delta: Float) {
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {

    }

    override fun dispose() {
    }
}
