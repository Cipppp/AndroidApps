package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaControllerr = MediaController(this)
        mediaControllerr.setAnchorView(videoView)

//        val onlineUri = Uri.parse("some link")
        val offlineUri = Uri.parse("android.resource://$packageName/${R.raw.videotest}")
        videoView.setMediaController(mediaControllerr)
        videoView.setVideoURI(offlineUri)
        videoView.requestFocus()
        videoView.start()
    }
}