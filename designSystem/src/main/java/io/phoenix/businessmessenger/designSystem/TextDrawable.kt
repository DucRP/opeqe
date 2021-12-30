package io.phoenix.businessmessenger.designSystem

import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import kotlin.math.min


class TextDrawable(private val builder: Builder) : ShapeDrawable(builder.shape) {
    private val textPaint: Paint = Paint()
    private val borderPaint: Paint = Paint()
    private val SHADE_FACTOR = 0.9f
    private val text = builder.text

    init {
        textPaint.apply {
            color = builder.textColor
            isAntiAlias = true
            style = Paint.Style.FILL
            textAlign = Paint.Align.CENTER
        }
        borderPaint.apply {
            color = getDarkerShade(color)
            style = Paint.Style.STROKE
        }
        val paint = paint
        paint.color = builder.color
    }


    private fun getDarkerShade(color: Int): Int {
        return Color.rgb(
            (SHADE_FACTOR * Color.red(color)).toInt(),
            (SHADE_FACTOR * Color.green(color)).toInt(),
            (SHADE_FACTOR * Color.blue(color)).toInt()
        )
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val r = bounds
        val count = canvas.save()
        canvas.translate(r.left.toFloat(), r.top.toFloat())
        val width = if (builder.width < 0) r.width() else builder.width
        val height = if (builder.height < 0) r.height() else builder.height
        val fontSize = min(width, height) / 2.5
        textPaint.textSize = fontSize.toFloat()
        canvas.drawText(
            text,
            width / 2f,
            height / 2f - (textPaint.descent() + textPaint.ascent()) / 2,
            textPaint
        )
        canvas.restoreToCount(count)
    }

    override fun setAlpha(alpha: Int) {
        textPaint.alpha = alpha
    }


    override fun setColorFilter(cf: ColorFilter?) {
        textPaint.colorFilter = cf
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun getIntrinsicWidth(): Int {
        return builder.width
    }

    override fun getIntrinsicHeight(): Int {
        return builder.height
    }


    data class Builder(
        val text: String = "",

        val color: Int = Color.GRAY,

        var textColor: Int = Color.WHITE,

        val width: Int = -1,

        val height: Int = -1,

        val shape: RectShape = OvalShape(),

        val toUpperCase: Boolean = false,
    )
}