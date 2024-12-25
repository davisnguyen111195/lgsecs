package io.github.lgsecs.ecs

interface ButtonAction {
    fun execute()
}


class IncreaseSpeedAction(private val speedComponent: SpeedComponent) : ButtonAction {
    override fun execute() {
        speedComponent.speed += 10f
        println("Speed increased to ${speedComponent.speed}")
    }
}

class DecreaseSpeedAction(private val speedComponent: SpeedComponent) : ButtonAction {
    override fun execute() {
        speedComponent.speed -= 10f
        println("Speed decreased to ${speedComponent.speed}")
    }
}

class ResetSpeedAction(private val speedComponent: SpeedComponent) : ButtonAction {
    override fun execute() {
        speedComponent.speed = 0f
        println("Speed reset to 0")
    }
}
