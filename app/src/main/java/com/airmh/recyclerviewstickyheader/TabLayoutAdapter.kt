package com.airmh.recyclerviewstickyheader

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class TabLayoutAdapter(fm : FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                StickyFragment()
            }
            1 -> {
                ItemFragment()
            } else -> ItemFragment()
        }
    }

    override fun getCount() = 2

}