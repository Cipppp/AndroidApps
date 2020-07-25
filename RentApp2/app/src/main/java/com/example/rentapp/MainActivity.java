package com.example.rentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables
    Animation topAnim, bottomAnim;
    ImageView image2;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int SPLASH_SCREEN = 5000;

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Hooks
        image2 = findViewById(R.id.imageView2);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);

        image2.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent( MainActivity.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}