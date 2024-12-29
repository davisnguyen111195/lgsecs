package io.github.lgsecs.views.lgsPanel

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.input.GestureDetector.GestureListener
import com.badlogic.gdx.math.Vector2
import io.github.lgsecs.Main.Companion.gridSize
import kotlin.math.ceil
import kotlin.math.floor

class WorldGrid(
    private val camera: OrthographicCamera,
    private val shapeRenderer: ShapeRenderer
) :
    GestureListener {
    private var currentZoom = 1f
    private var lastZoomDistance = 0f

    fun worldGridUpdate() {

        val left = camera.position.x - camera.viewportWidth / 2 * camera.zoom
        val right = camera.position.x + camera.viewportWidth / 2 * camera.zoom
        val top = camera.position.y + camera.viewportHeight / 2 * camera.zoom
        val bottom = camera.position.y - camera.viewportWidth / 2 * camera.zoom

        val startX = (floor(left / gridSize) * gridSize).toInt()
        val endX = (ceil(right / gridSize) * gridSize).toInt()
        val startY = (floor(bottom / gridSize) * gridSize).toInt()
        val endY = (ceil(top / gridSize) * gridSize).toInt()
        shapeRenderer.color = Color.BLACK
        shapeRenderer.projectionMatrix = camera.combined

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)

        for (i in startX..endX step gridSize) {
            for (k in startY..endY step gridSize) {
                shapeRenderer.circle(i.toFloat(), k.toFloat(), 1f)
            }
        }


        shapeRenderer.end()


        //LINE
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
//
//        for (i in startX..endX step gridSize) {
//            shapeRenderer.line(i.toFloat(), startY.toFloat(), i.toFloat(), endY.toFloat())
//        }
//
//        for(j in startY..endY step gridSize){
//            shapeRenderer.line(startX.toFloat(), j.toFloat(), endX.toFloat(), j.toFloat())
//        }
//
//        shapeRenderer.end()

    }


    override fun touchDown(x: Float, y: Float, pointer: Int, button: Int): Boolean = false

    override fun tap(x: Float, y: Float, count: Int, button: Int): Boolean = false

    override fun longPress(x: Float, y: Float): Boolean = false

    override fun fling(velocityX: Float, velocityY: Float, button: Int): Boolean = false

    override fun pan(x: Float, y: Float, deltaX: Float, deltaY: Float): Boolean {
        camera.translate(-deltaX * currentZoom, deltaY * currentZoom)
        println("pan -> ${-deltaX * currentZoom} - ${deltaY * currentZoom}")
        camera.update()
        return true
    }

    override fun panStop(x: Float, y: Float, pointer: Int, button: Int): Boolean {
        currentZoom = camera.zoom
        return true
    }

    override fun zoom(initialDistance: Float, distance: Float): Boolean {
        camera.zoom = (initialDistance / distance) * currentZoom
        camera.zoom = camera.zoom.coerceIn(0.1f, 1f)
        camera.update()
        return true
    }

    override fun pinch(
        initialPointer1: Vector2?,
        initialPointer2: Vector2?,
        pointer1: Vector2?,
        pointer2: Vector2?
    ): Boolean {
        if (initialPointer1 == null || initialPointer2 == null || pointer1 == null || pointer2 == null) {
            return false
        }

        val initialDistance = initialPointer1.dst(initialPointer2)
        val currentDistance = pointer1.dst(pointer2)

        if (currentDistance == lastZoomDistance) {
            return false
        }

        lastZoomDistance = currentDistance

        val zoomFactor = (initialDistance / currentDistance) * currentZoom

        camera.zoom = zoomFactor

        camera.zoom = camera.zoom.coerceIn(0.1f, 3f)
        println("pinch -> ${camera.position.x} - ${camera.position.y}")
        camera.update()
        return true
    }

    override fun pinchStop() {
        currentZoom = camera.zoom
    }

}
