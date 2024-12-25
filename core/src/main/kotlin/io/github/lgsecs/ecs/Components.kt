package io.github.lgsecs.ecs

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.Entity
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

class UIComponent : Component {
    var actor: Actor? = null
    var action: ButtonAction? = null
}


class SpeedComponent : Component {
    var speed = 0f
}


 fun createButtonEntity(
    engine: Engine,
    skin: Skin,
    text: String,
    x: Float,
    y: Float,
    action: ButtonAction
): Entity {
    val buttonEntity = engine.createEntity()
    val button = TextButton(text, skin)
    button.setPosition(x, y)
    button.addListener(object : ClickListener() {
        override fun clicked(event: InputEvent, x: Float, y: Float) {
            action.execute()  // Thực thi hành động khi nhấn nút
        }
    })
    val uiComponent = UIComponent().apply {
        actor = button
        this.action = action
    }
    buttonEntity.add(uiComponent)
    return buttonEntity
}
