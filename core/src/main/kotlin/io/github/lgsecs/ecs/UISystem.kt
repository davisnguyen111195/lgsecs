package io.github.lgsecs.ecs

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.scenes.scene2d.Stage

class UISystem(private val stage: Stage) : EntitySystem() {
    override fun update(deltaTime: Float) {
        // Lặp qua các entity có UIComponent
        for (entity in engine.getEntitiesFor(Family.all(UIComponent::class.java).get())) {
            val uiComponent = entity.getComponent(UIComponent::class.java)
            val actor = uiComponent.actor

            // Nếu actor không có trong stage, thêm nó vào
            if (actor != null && !stage.actors.contains(actor, true)) {
                stage.addActor(actor)
            }
        }
    }
}
