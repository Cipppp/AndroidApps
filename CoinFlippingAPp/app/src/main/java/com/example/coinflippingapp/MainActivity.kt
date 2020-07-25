package com.example.coinflippingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onCoinTap()
    }

    private fun onCoinTap() {
        iv_coin.setOnClickListener{
            val randomNumber = (1..2).random()

            if (randomNumber == 1) {
                flipTheCoin(R.drawable.ic_heads, "Heads")
            } else {
                flipTheCoin(R.drawable.ic_tails, "Tails")
            }
        }
    }

    private fun flipTheCoin(imageId: Int, coinSide: String) {
        iv_coin.animate().apply{
            duration = 1000
            rotationYBy(1800f)
            iv_coin.isClickable = true
        }.withEndAction {
            iv_coin.setImageResource(imageId)
            Toast.makeText(this, coinSide, Toast.LENGTH_SHORT).show()
            iv_coin.isClickable = true
        }.start()
    }
}