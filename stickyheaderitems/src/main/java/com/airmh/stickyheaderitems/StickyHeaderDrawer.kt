package com.airmh.stickyheaderitems

import android.graphics.Canvas
import android.view.View

class StickyHeaderDrawer private constructor() {
    private object Instance { val INSTANCE = StickyHeaderDrawer() }

    companion object {
        val instance : StickyHeaderDrawer by lazy { Instance.INSTANCE }
    }

    fun drawStickyHeader(canvas: Canvas, stickyHeaderView : View) {
        canvas.save()
        canvas.translate(0f, 0f)
        stickyHeaderView.draw(canvas)
        canvas.restore()
    }

}