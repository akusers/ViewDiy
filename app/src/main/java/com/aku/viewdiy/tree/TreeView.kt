package com.aku.viewdiy.tree

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Zsc
 * @date   2019/11/6
 * @desc
 */
class TreeView @JvmOverloads
constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint by lazy { Paint() }
    private val treeCanvas by lazy { Canvas() }
    private lateinit var bitmap: Bitmap
    private var growingBranches: MutableList<Branch> = mutableListOf()

    private val mData by lazy {
        arrayOf(
            arrayOf(0, -1, 217, 490, 252, 60, 182, 10, 30, 100),
            arrayOf(1, 0, 222, 310, 137, 227, 22, 210, 13, 100),
            arrayOf(2, 1, 132, 245, 116, 240, 76, 205, 2, 40),
            arrayOf(3, 0, 232, 255, 282, 166, 362, 155, 12, 100),
            arrayOf(4, 3, 260, 210, 330, 219, 343, 236, 3, 80),
            arrayOf(5, 0, 217, 91, 219, 58, 216, 27, 3, 40),
            arrayOf(6, 0, 228, 207, 95, 57, 10, 54, 9, 80),
            arrayOf(7, 6, 109, 96, 65, 63, 53, 15, 2, 40),
            arrayOf(8, 6, 180, 155, 117, 125, 77, 140, 4, 60),
            arrayOf(9, 0, 228, 167, 290, 62, 360, 31, 6, 100),
            arrayOf(10, 9, 272, 103, 328, 87, 330, 81, 2, 80)
        )
    }

    init {
        growingBranches.add(getBranches())
    }


    private fun getBranches(): Branch {

        val branches = mData.map { Branch(it) }
        branches.forEach {
            branches.getOrNull(it.parentId)?.addChild(it)
        }
        return branches[0]

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        treeCanvas.setBitmap(bitmap)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawBranches()
        canvas.drawBitmap(bitmap, 0F, 0F, paint)
    }

    private fun drawBranches() {
        val tempList: MutableList<Branch> = mutableListOf()
        if (growingBranches.isNotEmpty()) {
            val iterator = growingBranches.iterator()
            while (iterator.hasNext()) {
                treeCanvas.save()
                treeCanvas.translate(width/2F-434,height-980F)
                val branch = iterator.next()
                if (!branch.grow(treeCanvas, paint, 2)) {
                    iterator.remove()
                    tempList.addAll(branch.childList)
                }
                treeCanvas.restore()
            }
        }
        growingBranches.addAll(tempList)
        if(growingBranches.isNotEmpty()){
            invalidate()
        }


    }


}