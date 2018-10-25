package com.airmh.stickyheaderitems

import android.view.View

data class StickyHeaderValue(val isSticky : Boolean, val stickyValue : Any?)
class VarArgsData(vararg val items : Any)

class StickyHeaderHandler private constructor() {

    private object Instance { val INSTANCE = StickyHeaderHandler() }

    companion object {
        val instance : StickyHeaderHandler by lazy { Instance.INSTANCE }
    }

    fun handlingStickyHeaderView(headerView : View, stickyValue : Any?) {
        //TODO Handling headerView
        stickyValue?.let {
            val rxSubjectHelper = RxSubjectHelper.instance
            val params =VarArgsData(headerView, stickyValue)
            rxSubjectHelper.publishSubject(params)


            /*val valueObject = it as StickyHeaderValue
            (stickyHeaderView as ViewGroup).getChildAt(0)
            (titleView as TextView).text = valueObject.stickyValue as String*/
        }
    }
}