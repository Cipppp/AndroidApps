package com.example.googleauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
//        If user is not authenticated, send him to SignInActivity to authenticate first. Else send him to DashbordActivity
        Handler().postDelayed({
            if (user != null)  {
                val dashbordIntent = Intent(this, DashbordActivity::class.java)
                startActivity(dashbordIntent)
                finish()
            } else {
                val signInIntent = Intent(this, SignInActivity::class.java)
                startActivity(signInIntent)
                finish()
            }
        }, 2000)
    }
}