package com.airmh.recyclerviewstickyheader

import android.view.View
import android.widget.TextView
import com.airmh.stickyheaderitems.StickyHeaderValue

class RecyclerViewHolder(itemView : View) : ParentViewHolder(itemView) {

    private val textView by lazy {
        itemView.findViewById<TextView>(R.id.item_textView)
    }

    override fun setData(datas: HolderDatas) {
        textView.text = datas.text
        itemView.tag = StickyHeaderValue(isSticky = false, stickyValue = datas.stikcyHeaderTitle)
    }

}