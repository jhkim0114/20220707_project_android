package com.example.jhkim20220707

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.LinearLayout

class CircleAnimIndicator : LinearLayout {
    private var mContext: Context

    //원 사이의 간격
    private var itemMargin = 10

    //애니메이션 시간
    private var animDuration = 250
    private var mDefaultCircle = 0
    private var mSelectCircle = 0
    private lateinit var imageDot: Array<ImageView?>
    fun setAnimDuration(animDuration: Int) {
        this.animDuration = animDuration
    }

    fun setItemMargin(itemMargin: Int) {
        this.itemMargin = itemMargin
    }

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
    }

    /**
     *
     * 기본 점 생성
     * @param count 점의 갯수
     * @param defaultCircle 점의 이미지
     */
    fun createDotPanel(count: Int, defaultCircle: Int, selectCircle: Int) {
        mDefaultCircle = defaultCircle
        mSelectCircle = selectCircle
        imageDot = arrayOfNulls<ImageView>(count)
        for (i in 0 until count) {
            imageDot[i] = ImageView(mContext)
            val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            params.topMargin = itemMargin
            params.bottomMargin = itemMargin
            params.leftMargin = itemMargin
            params.rightMargin = itemMargin
            params.gravity = Gravity.CENTER
            imageDot[i]?.setLayoutParams(params)
            imageDot[i]?.setImageResource(defaultCircle)
            imageDot[i]?.setTag(imageDot[i]!!.getId(), false)
            this.addView(imageDot[i])
        }


        //첫인덱스 선택
        selectDot(0)
    }

    /**
     *
     * 선택된 점 표시
     * @param position
     */
    fun selectDot(position: Int) {
        for (i in imageDot.indices) {
            if (i == position) {
                imageDot[i]?.setImageResource(mSelectCircle)
                selectScaleAnim(imageDot[i], 1f, 1.5f)
            } else {
                if (imageDot[i]?.getTag(imageDot[i]!!.getId()) as Boolean == true) {
                    imageDot[i]?.setImageResource(mDefaultCircle)
                    defaultScaleAnim(imageDot[i], 1.5f, 1f)
                }
            }
        }
    }

    /**
     *
     * 선택된 점의 애니메이션
     * @param view
     * @param startScale
     * @param endScale
     */
    fun selectScaleAnim(view: View?, startScale: Float, endScale: Float) {
        val anim: Animation = ScaleAnimation(
            startScale, endScale,
            startScale, endScale,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim.setFillAfter(true)
        anim.setDuration(animDuration.toLong())
        view?.startAnimation(anim)
        view?.setTag(view.getId(), true)
    }

    /**
     *
     * 선택되지 않은 점의 애니메이션
     * @param view
     * @param startScale
     * @param endScale
     */
    fun defaultScaleAnim(view: View?, startScale: Float, endScale: Float) {
        val anim: Animation = ScaleAnimation(
            startScale, endScale,
            startScale, endScale,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim.setFillAfter(true)
        anim.setDuration(animDuration.toLong())
        view?.startAnimation(anim)
        view?.setTag(view.getId(), false)
    }
}