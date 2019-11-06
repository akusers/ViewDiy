package com.aku.viewdiy.tree

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF

/**
 * @author Zsc
 * @date   2019/11/6
 * @desc
 */
class Branch(data: Array<Int>) {

    companion object {
        private const val branchColor = 0xFF773322.toInt()

    }

    private val id = data[0]

    val parentId = data[1]


    val childList = mutableListOf<Branch>()

    private val points: Array<PointF> = arrayOf(
        PointF(data[2].toFloat(), data[3].toFloat()),
        PointF(data[4].toFloat(), data[5].toFloat()),
        PointF(data[6].toFloat(), data[7].toFloat())
    )

    private var radius = data[8].toFloat()

    private val maxLength = data[9]
    private var currentLength = 0

    private var part = 1F / maxLength

    private var growX = 100F
    private var growY = 100F


    fun addChild(branch: Branch) {
        childList.add(branch)
    }


    fun grow(canvas: Canvas, paint: Paint, scaleFactor: Int): Boolean {
        if (currentLength < maxLength) {
            bezier(part * currentLength)
            draw(canvas, paint, scaleFactor)
            currentLength++
            radius *= 0.97F
            return true
        }

        return false
    }


    private fun bezier(t: Float) {
        val c0 = (1 - t) * (1 - t)
        val c1 = 2 * (1 - t) * t
        val c2 = t * t
        growX = c0 * points[0].x + c1 * points[1].x + c2 * points[2].x
        growY = c0 * points[0].y + c1 * points[1].y + c2 * points[2].y


    }

    private fun draw(canvas: Canvas, paint: Paint, scaleFactor: Int) {
        paint.color = branchColor
        canvas.save()
        canvas.scale(scaleFactor.toFloat(), scaleFactor.toFloat())
        canvas.drawCircle(growX, growY, radius, paint)
        canvas.restore()

    }

}