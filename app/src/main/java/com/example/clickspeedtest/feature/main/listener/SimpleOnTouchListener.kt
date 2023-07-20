package com.example.clickspeedtest.feature.main.listener

import android.annotation.SuppressLint
import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

class SimpleOnTouchListener(
    context: Context,
    private val onSingleTapUp: () -> Unit
) : SimpleOnGestureListener(), OnTouchListener {

    private val gestureDetector = GestureDetector(context, this)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        onSingleTapUp()
        return true
    }

}
