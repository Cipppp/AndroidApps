package com.example.rentapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rentappkotlin.Dashboard
import com.example.rentappkotlin.R

class MainActivity : AppCompatActivity() {
    // Variables
    var topAnim: Animation? = null
    var bottomAnim: Animation? = null
    var image2: ImageView? = null
    var logo: TextView? = null
    var slogan: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val SPLASH_SCREEN = 5000
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Hooks
        image2 = findViewById(R.id.imageView2)
        logo = findViewById(R.id.textView)
        slogan = findViewById(R.id.textView2)
        image2.setAnimation(topAnim)
        logo.setAnimation(bottomAnim)
        slogan.setAnimation(bottomAnim)
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, Dashboard::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN.toLong())
    }
}