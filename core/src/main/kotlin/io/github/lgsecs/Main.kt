package io.github.lgsecs

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import io.github.lgsecs.utils.LGSAssetManager
import io.github.lgsecs.views.IntroScreen


class Main : Game() {
    override fun create()  {
        this.setScreen(IntroScreen(this))
    }

    override fun render() {
        super.render()

    }

    override fun getScreen(): Screen {
        return super.getScreen()
    }

    override fun setScreen(screen: Screen?) {
        super.setScreen(screen)
    }

    override fun dispose() {
        super.dispose()
    }

    override fun resume() {
        super.resume()
    }

    override fun pause() {
        super.pause()
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
    }

    companion object {
        val WIDTH by lazy { Gdx.graphics.width.toFloat() }
        val HEIGHT by lazy { Gdx.graphics.height.toFloat() }
        val gridSize = 50
        val assetManager : LGSAssetManager by lazy { LGSAssetManager.instance }
    }

}
