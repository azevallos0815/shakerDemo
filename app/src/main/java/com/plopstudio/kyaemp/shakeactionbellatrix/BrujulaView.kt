package com.plopstudio.kyaemp.shakeactionbellatrix

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BrujulaView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val barPaint = Paint()
    private val thumbPaint = Paint()
    private val defaultBarWidth = resources.getDimensionPixelSize(R.dimen.volume_bar_default_width)
    private val defaultBarHeight = resources.getDimensionPixelSize(R.dimen.volume_bar_default_height)

    init {
        barPaint.color = Color.GRAY
        thumbPaint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(width.toFloat()/2.0F,height.toFloat()/2.0F,height.toFloat()/2.0F,thumbPaint)
        canvas.drawRect(0.0F,0.0F,width.toFloat(),height.toFloat(),barPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode =  MeasureSpec.getMode(widthMeasureSpec)
        val heightMode =  MeasureSpec.getMode(heightMeasureSpec)

        val widthSize =  MeasureSpec.getSize(widthMeasureSpec)
        val heightSize =  MeasureSpec.getSize(heightMeasureSpec)

        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.AT_MOST -> defaultBarWidth
            MeasureSpec.UNSPECIFIED -> defaultBarWidth
            else -> defaultBarWidth
        }

        val height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> defaultBarHeight
            MeasureSpec.UNSPECIFIED -> defaultBarHeight
            else -> defaultBarHeight
        }

        setMeasuredDimension(width,height);
    }
}