package com.airmh.recyclerviewstickyheader

import android.view.View
import android.widget.TextView
import com.airmh.stickyheaderitems.StickyHeaderValue

class TitleViewHolder(itemView : View) : ParentViewHolder(itemView) {

    private val titleTextView by lazy {
        itemView.findViewById(R.id.title_textview) as TextView
    }
    override fun setData(datas: HolderDatas) {
        titleTextView.text = "STICKY HEADER ${datas.position}"
        itemView.tag = StickyHeaderValue(true, datas.stikcyHeaderTitle)
    }
}