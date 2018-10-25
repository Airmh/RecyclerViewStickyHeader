package com.airmh.recyclerviewstickyheader

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CoordinatorFragment : Fragment() {
    private lateinit var viewPager : ViewPager
    private lateinit var tabLayout : TabLayout
    private val tabAdapter : TabLayoutAdapter by lazy {
        TabLayoutAdapter(fragmentManager)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.coordinator_fragment, container, false)
        /*recyclerView = view.findViewById(R.id.recyclerView)
        adapter = RecyclerViewAdapter()*/
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("최근본"))
        tabLayout.addTab(tabLayout.newTab().setText("찜"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        viewPager.adapter = tabAdapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}