package io.github.lgsecs.models

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

abstract class CircuitPart(
    private val shapeRenderer: ShapeRenderer,
    private var x: Float,
    private var y: Float,
) : LGSLevelListener{

    private val size = 150f

    override fun changeLevel(e: LGSLevelEvent) {}

    fun drawingPart() {
        shapeRenderer.rect(x, y, size, size)
    }

}
