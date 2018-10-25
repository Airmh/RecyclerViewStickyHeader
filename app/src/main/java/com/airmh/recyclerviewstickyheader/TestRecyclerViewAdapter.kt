package com.airmh.recyclerviewstickyheader

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class TestRecyclerViewAdapter : RecyclerView.Adapter<ParentViewHolder> {

    private val itemList : ArrayList<HolderDatas>  = arrayListOf<HolderDatas>()

    constructor(type : Int) : super() {

        var stickyTitle = ""

        when(type) {
            0 -> {
                for(i in 0..35) {

                    when(i) {
                        0 -> {
                            val data = HolderDatas(false, "", 0, i, "")
                            itemList.add(data)
                        } 1 -> {
                            stickyTitle = "STICKY HEADER $i"
                            itemList.add(HolderDatas(true, "", 1, i, stickyTitle))
                        } else -> {

                            val data = if (i % 6 == 0) {
                                stickyTitle = "STICKY HEADER $i"
                                HolderDatas(true, "", 1, i, stickyTitle)
                            }
                            else
                                HolderDatas(false, "TEST $i GOGOGOGOGO -------------", 2, i, stickyTitle)

                            itemList.add(data)
                        }
                    }
                }
            }

            1 -> {
                for(i in 0..50) {
                    itemList.add(HolderDatas(false, "NORMAL LIST $i", 3, i, ""))
                }

            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder = when (viewType) {
        0 -> {
            HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.title_holder, null))

        } 1 -> {
            TitleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sticky_title_item, null))

        } 2 -> {
            RecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_item, null))

        } else -> {
            RecyclerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_item, null))
        }
    }
    override fun getItemCount() = itemList?.size
    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) = holder.setData(itemList[position])
    override fun getItemViewType(position: Int) =  itemList[position].viewType

}