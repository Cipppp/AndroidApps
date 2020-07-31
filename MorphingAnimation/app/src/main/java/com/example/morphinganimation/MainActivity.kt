package com.example.morphinganimation

import android.annotation.TargetApi
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var avd:AnimatedVectorDrawableCompat
    lateinit var avd2:AnimatedVectorDrawable
    var switchNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        imageView.setOnClickListener(object: View.OnClickListener {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onClick(view:View) {
                if (switchNumber == 0)
                {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.avd_plus_to_minus))
                    val drawable = imageView.getDrawable()
                    if (drawable is AnimatedVectorDrawableCompat)
                    {
                        avd = drawable as AnimatedVectorDrawableCompat
                        avd.start()
                    }
                    else if (drawable is AnimatedVectorDrawable)
                    {
                        avd2 = drawable as AnimatedVectorDrawable
                        avd2.start()
                    }
                    switchNumber++
                }
                else
                {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.avd_minus_to_plus))
                    val drawable = imageView.getDrawable()
                    if (drawable is AnimatedVectorDrawableCompat)
                    {
                        avd = drawable as AnimatedVectorDrawableCompat
                        avd.start()
                    }
                    else if (drawable is AnimatedVectorDrawable)
                    {
                        avd2 = drawable as AnimatedVectorDrawable
                        avd2.start()
                    }
                    switchNumber--
                }
            }
        })

    }
}