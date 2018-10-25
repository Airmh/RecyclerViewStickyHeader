package com.airmh.recyclerviewstickyheader

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airmh.stickyheaderitems.StickyHeaderViewDecoration

class StickyFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = TestRecyclerViewAdapter(0)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.recyclerview_item, container, false)
        recyclerView = view.findViewById(R.id.childRecyclerView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.addItemDecoration(StickyHeaderViewDecoration(/*R.layout.sticky_header_view*/))
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }
}