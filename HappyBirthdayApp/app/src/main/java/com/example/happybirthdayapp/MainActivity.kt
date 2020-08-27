package com.example.happybirthdayapp

import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.PathInterpolator
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cake_button.setOnClickListener {
            wishTextView.text = "Happy birthday Cipp"
        }


        // Arc button
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            val path = Path().apply {
//                arcTo(0f, 0f, 600f, 1200f, 90f, -180f, true)
//            }
//            val animator = ObjectAnimator.ofFloat(cake_button, View.X, View.Y, path).apply {
//                duration = 2000
//                start()
//            }
//        } else {
//            // Create animator without using curved path
//        }



        findViewById<View>(R.id.imageView).also { img ->
            SpringAnimation(img, DynamicAnimation.TRANSLATION_Y).apply {
                //Setting the damping ratio to create a low bouncing effect.
                spring.dampingRatio = SpringForce.DAMPING_RATIO_LOW_BOUNCY
            }
        }





    }

}