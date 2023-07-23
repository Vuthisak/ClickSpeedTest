package com.example.clickspeedtest.feature.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CircleNumberView : AppCompatTextView {
    private lateinit var paint: Paint
    private lateinit var rectF: RectF
    private var strokeWidth = 2
    private var number = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context, attrs
    ) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init()
    }

    private fun init() {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        rectF = RectF()
    }

    override fun onDraw(canvas: Canvas) {
        rectF[strokeWidth.toFloat(), strokeWidth.toFloat(), (width - strokeWidth).toFloat()] =
            (height - strokeWidth).toFloat()
        canvas.drawOval(rectF, paint)
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.textSize = (height / 2).toFloat()
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(
            number.toString(),
            (width / 2).toFloat(),
            height / 2 - (paint.descent() + paint.ascent()) / 2,
            paint
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        val height = measuredHeight
        val diameter = width.coerceAtLeast(height)
        setMeasuredDimension(diameter, diameter)
    }

    fun setColor(color: Int) {
        paint.color = color
        invalidate()
    }

    fun setStrokeWidth(strokeWidth: Int) {
        this.strokeWidth = strokeWidth
        invalidate()
    }

    fun setNumber(number: Int) {
        this.number = number
        invalidate()
    }
}