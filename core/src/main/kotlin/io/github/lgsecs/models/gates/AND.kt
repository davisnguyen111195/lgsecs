package io.github.lgsecs.models.gates

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import io.github.lgsecs.models.Gate

class AND(
    private val shapeRenderer: ShapeRenderer,
    private var x: Float,
    private var y: Float
) : Gate(x, y) {
    private val size = 150f
    fun drawBoundingBox() {
        shapeRenderer.rect(x, y, size, size)
    }


}
