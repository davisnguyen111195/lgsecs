package io.github.lgsecs

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.viewport.ScreenViewport
import io.github.lgsecs.ecs.DecreaseSpeedAction
import io.github.lgsecs.ecs.IncreaseSpeedAction
import io.github.lgsecs.ecs.ResetSpeedAction
import io.github.lgsecs.ecs.SpeedComponent
import io.github.lgsecs.ecs.SpeedSystem
import io.github.lgsecs.ecs.UISystem
import io.github.lgsecs.ecs.createButtonEntity


class Main : Game(){
    lateinit var engine: Engine
    lateinit var stage: Stage
    lateinit var skin: Skin

    override fun getScreen(): Screen {
        return super.getScreen()
    }

    override fun setScreen(screen: Screen?) {
        super.setScreen(screen)
    }

    override fun dispose() {
        super.dispose()
        stage.dispose()
    }

    override fun resume() {
        super.resume()
    }

    override fun pause() {
        super.pause()
    }

    override fun render() {
        super.render()
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        engine.update(Gdx.graphics.deltaTime)
        stage.act(Math.min(Gdx.graphics.deltaTime, 1 / 30f))
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        stage.viewport.update(width, height, true)

    }

    override fun create() {
        engine = Engine()
        stage = Stage(ScreenViewport())
        Gdx.input.inputProcessor = stage

        // Tạo Skin cho UI
        skin = Skin(Gdx.files.internal("skin_compose_by_dat.json"))

        // Lấy Entity chứa SpeedComponent
        val speedComponent = engine.createEntity().apply {
            add(SpeedComponent())
        }.getComponent(SpeedComponent::class.java)

        // Tạo và thêm nút Tăng Tốc Độ
        val increaseSpeedEntity = createButtonEntity(engine, skin,"Increase Speed", 100f, 200f, IncreaseSpeedAction(speedComponent))

        // Tạo và thêm nút Giảm Tốc Độ
        val decreaseSpeedEntity = createButtonEntity(engine, skin,"Decrease Speed", 100f, 100f, DecreaseSpeedAction(speedComponent))

        // Tạo và thêm nút Đặt Lại Tốc Độ
        val resetSpeedEntity = createButtonEntity(engine, skin,"Reset Speed", 100f, 0f, ResetSpeedAction(speedComponent))

        // Thêm các entity vào engine và stage
        engine.addEntity(increaseSpeedEntity)
        engine.addEntity(decreaseSpeedEntity)
        engine.addEntity(resetSpeedEntity)

        // Thêm UISystem vào engine
        engine.addSystem(UISystem(stage))
        engine.addSystem(SpeedSystem())
    }
}
