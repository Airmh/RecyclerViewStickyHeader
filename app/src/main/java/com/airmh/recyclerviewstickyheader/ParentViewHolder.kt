package com.airmh.recyclerviewstickyheader

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class ParentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    abstract fun setData(datas : HolderDatas)
}
