package com.example.lektion3

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView

class FlipImageView @JvmOverloads constructor(context: Context,
                    attrs: AttributeSet? = null,
                    defStyleAttr: Int = 0,
                    var onDownImage : Int? = null,
                    var defaultImage : Drawable? = null)
    : AppCompatImageView(context, attrs, defStyleAttr) {

    init {
        defaultImage = drawable
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when( event?.action) {
            MotionEvent.ACTION_DOWN -> {
                if (onDownImage != null)
                    setImageResource(onDownImage!!)
            }
            MotionEvent.ACTION_UP -> {
                if (defaultImage != null) {
                    setImageDrawable(defaultImage)
                }
            }
        }
        return true
    }

    // detta gjorde vi inte på lektionen
    // men om vi vill att det ska gå att byta defaultbild i vår FlipImage
    // så skulle vi tex kunna göra så här
 /*   override fun setImageResource(resId: Int) {
        super.setImageResource(resId)

        if (resId != onDownImage)
            defaultImage = resources.getDrawable(resId, null)
    }*/



}