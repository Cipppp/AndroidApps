package com.example.animationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Declare animation
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb)

        val btt = AnimationUtils.loadAnimation(this, R.anim.btt)
        val btt2 = AnimationUtils.loadAnimation(this, R.anim.btt2)
        val btt3 = AnimationUtils.loadAnimation(this, R.anim.btt3)

        val btn_course = AnimationUtils.loadAnimation(this, R.anim.btn_course)

        val headerTitle = findViewById(R.id.headerTitle) as TextView
        val subtitle = findViewById(R.id.subtitle) as TextView

        val ic_cards = findViewById(R.id.ic_cards) as ImageView

        val resultOne = findViewById(R.id.resultOne) as LinearLayout
        val resultTwo = findViewById(R.id.resultTwo) as LinearLayout
        val resultThree = findViewById(R.id.resultThree) as LinearLayout

        val btn_next_course = findViewById(R.id.btn_next_course) as Button

        // Set animation
        headerTitle.startAnimation(ttb)
        subtitle.startAnimation(ttb)

        ic_cards.startAnimation(stb)

        resultOne.startAnimation(btt)
        resultTwo.startAnimation(btt2)
        resultThree.startAnimation(btt3)

        btn_next_course.startAnimation(btn_course)












    }
}