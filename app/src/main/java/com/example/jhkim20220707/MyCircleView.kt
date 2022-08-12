package com.example.jhkim20220707

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyCircleView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    var paint = Paint()

    var circleX = mutableListOf(500f, 700f, 900f)
    var circleY = 150f
    var circleRadius = 40f

    var selectCircleX = mutableListOf(0f, 0f)
    var selectCircleY = 150f

    var currentCircleX = mutableListOf(0f, 0f)
    var tempOffset = 0f

    var isForward = true

    val colorGray = Color.GRAY
    val colorYellow = Color.YELLOW
    val colorRed = Color.RED
    val colorBlue = Color.BLUE

    fun setCircleValue(p: Int, offset: Float) {
        if (offset != 0.0f) {
            // 페이징중..
            if (tempOffset == 0.0f && offset > 0.5f) {
                // 뒤로가는중..
                isForward = false
                currentCircleX[1] -= 200f
            }
            selectCircleX[1] = currentCircleX[1] + 200f * offset

            selectCircleX[0] = if (isForward && offset > 0.9f) {
                currentCircleX[0] + 200f * ((offset - 0.9f) * 10)
            } else if (!isForward && offset < 0.1f) {
                // 뒤로가는중..
                currentCircleX[0] + 200f * ((offset - 0.1f) * 10)
            } else {
                selectCircleX[0]
            }
        } else {
            // 페이징 하지 않는 상태
            isForward = true
            when(p) {
                0 -> {
                    pageCompletSetting(500f)
                }
                1 -> {
                    pageCompletSetting(700f)
                }
                2 -> {
                    pageCompletSetting(900f)
                }
            }
        }
        tempOffset = offset
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCircleBackground(canvas)
        drawCircleForeground(canvas)
    }

    private fun drawCircleBackground(canvas: Canvas?) {
        paint.color = colorGray
        circleX.forEach {
            canvas?.drawCircle(it, circleY, circleRadius, paint)
        }
    }

    private fun drawCircleForeground(canvas: Canvas?) {
        paint.color = colorYellow
        canvas?.drawCircle(selectCircleX[0], circleY, circleRadius, paint)

        paint.color = colorYellow
        canvas?.drawCircle(selectCircleX[1], circleY, circleRadius, paint)

        paint.color = colorYellow
        val rect = RectF(selectCircleX[0],circleY-40f,selectCircleX[1],circleY+40f)
        canvas?.drawRect(rect, paint)
    }

    private fun pageCompletSetting(x: Float) {
        currentCircleX[0] = x
        currentCircleX[1] = x
        selectCircleX[0] = x
        selectCircleX[1] = x
    }

}