package io.github.lgsecs.models

open class Gate(x: Float, y: Float) : CircuitPart(x, y) {

    override fun changeLevel(e: LGSLevelEvent) {
        super.changeLevel(e)
    }

}
