package io.github.lgsecs.models

class LGSLevelEvent {
    var mSource: CircuitPart
    lateinit var mTarget: LGSLevelListener
    var mLevel: Boolean = false
        set(value) {
            field = value
        }
    var mForce: Boolean = false

    constructor(source: CircuitPart) {
        mSource = source
        mLevel = false
        mForce = false
    }

    constructor(source: CircuitPart, level: Boolean) {
        mSource = source
        mLevel = level
        mForce = false
    }

    constructor(source: CircuitPart, level: Boolean, force: Boolean) {
        mSource = source
        mLevel = level
        mForce = force
    }

    constructor(source: CircuitPart, level: Boolean, force: Boolean, target: LGSLevelListener) {
        mSource = source
        mLevel = level
        mForce = force
        mTarget = target
    }
}
