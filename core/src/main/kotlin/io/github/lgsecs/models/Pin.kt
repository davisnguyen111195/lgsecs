package io.github.lgsecs.models

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Pin(shapeRenderer: ShapeRenderer, x: Float, y: Float) : CircuitPart(shapeRenderer, x, y) {


    override fun changeLevel(e: LGSLevelEvent) {
        super.changeLevel(e)
    }
}
