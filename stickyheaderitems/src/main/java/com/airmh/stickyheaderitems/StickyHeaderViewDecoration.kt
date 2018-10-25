package com.airmh.stickyheaderitems

import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StickyHeaderViewDecoration() : RecyclerView.ItemDecoration() {

    private var stickyHeaderView : View? = null
    private var inflateView : View? = null
    private var layoutId : Int = -1

    constructor(layoutId : Int) : this() {
        this.layoutId = layoutId
        isCustomHeaderView = true
    }

    private var isCustomHeaderView = false
    private val stickyHeaderHandler : StickyHeaderHandler by lazy {
        StickyHeaderHandler.instance
    }

    private val stickyHeaderDrawer : StickyHeaderDrawer by lazy {
        StickyHeaderDrawer.instance
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val topView = parent.getChildAt(0)
        val topViewPosition = parent.getChildAdapterPosition(topView)

        if (topViewPosition == RecyclerView.NO_POSITION) return

        topView.tag?.let {

            val stickyValueObject = it as StickyHeaderValue
            if (stickyValueObject.isSticky) {

                if (isCustomHeaderView) {
                    if (inflateView == null)
                        inflateView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

                    stickyHeaderView = inflateView
                    setViewSize(stickyHeaderView!!, parent)
                    stickyHeaderView!!.tag = StickyHeaderValue(true,  "")

                } else stickyHeaderView = topView

            }

            stickyHeaderView?.let {
                stickyHeaderViewDrawAndHandling(canvas = c, stickyHeaderView = it, value = stickyValueObject)
            }
        }
    }

    private fun stickyHeaderViewDrawAndHandling(canvas: Canvas, stickyHeaderView: View, value : StickyHeaderValue) {
        stickyHeaderHandler.handlingStickyHeaderView(stickyHeaderView, value)
        stickyHeaderDrawer.drawStickyHeader(canvas, stickyHeaderView)
    }

    private fun setViewSize(view: View, parent: ViewGroup) {
        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(parent.width, View.MeasureSpec.EXACTLY)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(parent.height, View.MeasureSpec.UNSPECIFIED)

        val childWidth = ViewGroup.getChildMeasureSpec(widthMeasureSpec, parent.paddingLeft + parent.paddingRight, view.layoutParams.width)
        val childHeight = ViewGroup.getChildMeasureSpec(heightMeasureSpec, parent.paddingTop + parent.paddingBottom, view.layoutParams.height)

        view.measure(childWidth, childHeight)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    }
}