package com.example.jhkim20220707

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class MyCircleView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    var paint = Paint()
    var circleX = 0f
    var circleY = 0f
    var circleRadius = 40f
    var selectCircleX = 0f
    var selectCircleY = 150f
    var currentCircleX = 500f
    var tempOffset = 0f

    fun setCircleValue(p: Int, offset: Float, offsetPixels: Int) {
        if (offset != 0.0f) {
            selectCircleX = if (tempOffset == 0.0f && offset > 0.5f) {
                currentCircleX -= 200
                currentCircleX + 200 * offset
            } else {
                currentCircleX + 200 * offset
            }
            Log.d("hoho selectCircleX", selectCircleX.toString())
        } else {
            when(p) {
                0 -> {
                    currentCircleX = 500f
                    selectCircleX = 500f
                }
                1 -> {
                    currentCircleX = 700f
                    selectCircleX = 700f
                }
                2 -> {
                    currentCircleX = 900f
                    selectCircleX = 900f
                }
            }
        }
        tempOffset = offset
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.GRAY
        circleX = 500f
        circleY = 150f
        canvas?.drawCircle(circleX, circleY, circleRadius, paint)

        paint.color = Color.GRAY
        circleX = 700f
        circleY = 150f
        canvas?.drawCircle(circleX, circleY, circleRadius, paint)

        paint.color = Color.GRAY
        circleX = 900f
        circleY = 150f
        canvas?.drawCircle(circleX, circleY, circleRadius, paint)

        paint.color = Color.YELLOW
        circleX = selectCircleX
        circleY = selectCircleY
        canvas?.drawCircle(circleX, circleY, circleRadius, paint)
    }

}