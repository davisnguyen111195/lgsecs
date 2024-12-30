package io.github.lgsecs.models


abstract class CircuitPart(x: Float, y: Float) : LGSLevelListener {
    private var mX: Float = x
    private var mY: Float = y

    override fun changeLevel(e: LGSLevelEvent) {}
}
