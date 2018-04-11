package com.example.bijay.expandableviewdemo

import android.view.animation.DecelerateInterpolator
import android.animation.ValueAnimator
import android.view.View

/**
 * Class used for collapsing and expanding the particular view vertically.
 */
class ExpandCollapse {

    //Variable to get the maximum and minimum height of the view.
    var MinHeight: Int = 100
    var MaxHeight: Int = -1

    /**
     * Method to expand and collapse the particular view to the desired target Height
     * @param v the view which will be expanded or collapsed
     * @param duration time to taken to collapse or expand
     * @param targetHeight the height of the view before and after collapse
     */
    fun expandCollapse(v: View, duration: Int, targetHeight: Int) {

        val prevHeight = v.getHeight()

        if(prevHeight > MaxHeight)
            MaxHeight = prevHeight

        //Do not expand the textView if it is already expanded. This condition is to make sure the use is not expanding the view
        //for the first time when it is already expanded.
        if(targetHeight != -1) {
            //Assign the valueAnimator to height from current value to the target value
            val valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight)

            //Update the height to target height
            valueAnimator.addUpdateListener { animation ->
                v.getLayoutParams().height = animation.animatedValue as Int
                v.requestLayout()
            }

            //Type of animation to be applied i.e. DecelerateInterpolator and apply duration then start the animation
            valueAnimator.interpolator = DecelerateInterpolator()
            valueAnimator.duration = duration.toLong()
            valueAnimator.start()
        }
    }
}