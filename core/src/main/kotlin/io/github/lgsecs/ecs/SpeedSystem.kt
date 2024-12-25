package io.github.lgsecs.ecs

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family

class SpeedSystem : EntitySystem() {
    override fun update(deltaTime: Float) {
        // Lấy entity có SpeedComponent
        for (entity in engine.getEntitiesFor(Family.all(SpeedComponent::class.java).get())) {
            val speedComponent = entity.getComponent(SpeedComponent::class.java)
            println("Current speed: ${speedComponent.speed}")
        }
    }
}

