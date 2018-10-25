package com.airmh.recyclerviewstickyheader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.airmh.stickyheaderitems.RxSubjectHelper
import com.airmh.stickyheaderitems.StickyHeaderValue
import com.airmh.stickyheaderitems.VarArgsData
import io.reactivex.functions.Consumer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rxSubjectHelper =  RxSubjectHelper.instance
        rxSubjectHelper.subscribeSubject(Consumer {
            android.util.Log.v("","AIRMH varargs test $it")
            it as VarArgsData
            val testView = it.items[0] as View
            val stickyValue = it.items[1] as StickyHeaderValue
            testView.findViewById<TextView>(R.id.title_textview).text = "airmh did it!!! ${stickyValue.stickyValue as String}"
        })
    }
}
