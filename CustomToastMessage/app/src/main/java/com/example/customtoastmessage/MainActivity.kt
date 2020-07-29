package com.example.customtoastmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast,
            findViewById<ViewGroup>(R.id.toast_layout)
        )
        val toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        button.setOnClickListener { toast.show() }

    }
}

