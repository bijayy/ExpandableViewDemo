package com.example.bijay.expandableviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Creating singleton object of the ExpandCollapse class
    val expandCollapse = ExpandCollapse()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun expand(view: View) {

        //Expanding the textView within the duration of 2 seconds to the actual height of this which was before collapsing.
        expandCollapse.expandCollapse(textView, 2000, expandCollapse.MaxHeight);
    }

    fun collapse(view: View) {

        // //Collapsing the textView within the duration of 2 seconds to the actual height of this which was before expanding.
        expandCollapse.expandCollapse(textView, 2000, expandCollapse.MinHeight);
    }
}
