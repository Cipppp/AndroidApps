package com.example.signupfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()

        sign_up_btn.setOnClickListener {
            signUpUser()
        }
    }

    fun signUpUser() {
        if (email_text.text.toString().isEmpty()) {
            email_text.error = "Please enter email"
            email_text.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email_text.text.toString()).matches()) {
            email_text.error = "Please enter valid email"
            email_text.requestFocus()
            return
        }

        if (password_text.text.toString().isEmpty()) {
            password_text.error = "Please enter password"
            password_text.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email_text.text.toString(), password_text.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT).show()
                }

            }
    }
}