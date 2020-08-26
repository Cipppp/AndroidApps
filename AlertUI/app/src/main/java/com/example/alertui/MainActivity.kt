package com.example.alertui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tapadoo.alerter.Alerter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun buyIphoneXS(view: View) {
        Alerter.create(this)
            .setTitle("Buy Laptop")
            .setText("Are you sure you want to buy now?")
            .addButton("Buy", R.style.AlertButton, View.OnClickListener {
                Alerter.create(this)
                    .setTitle("Success")
                    .setText("You just paid $250")
                    .setBackgroundColorInt(Color.parseColor("#1abc9c"))
                    .setTextAppearance(Color.parseColor("#34495e"))
                    .show()
            })
            .setBackgroundColorInt(Color.parseColor("#e74c3c"))
            .setIcon(R.drawable.ic_baseline_laptop_24_white)
            .show()
    }
}