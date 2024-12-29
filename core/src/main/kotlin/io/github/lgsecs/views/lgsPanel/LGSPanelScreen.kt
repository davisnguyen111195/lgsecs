package io.github.lgsecs.views.lgsPanel

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.input.GestureDetector
import com.badlogic.gdx.scenes.scene2d.Stage
import io.github.lgsecs.Main.Companion.HEIGHT
import io.github.lgsecs.Main.Companion.WIDTH

class LGSPanelScreen : Screen {

    private lateinit var camera: OrthographicCamera
    private lateinit var stage: Stage
    private lateinit var listElementActor: ListElementActor
    private lateinit var wordGrid: WorldGrid
    private lateinit var shapeRenderer: ShapeRenderer

    override fun show() {
        camera = OrthographicCamera(WIDTH, HEIGHT)
        stage = Stage()
        listElementActor = ListElementActor(stage)
        println("LGSScreen")
        shapeRenderer = ShapeRenderer()
        wordGrid = WorldGrid(camera, shapeRenderer)
        Gdx.input.inputProcessor = InputMultiplexer(stage, GestureDetector(wordGrid))
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        wordGrid.worldGridUpdate()
        stage.act()
        stage.draw()

    }

    override fun resize(width: Int, height: Int) {
        camera.update()
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
