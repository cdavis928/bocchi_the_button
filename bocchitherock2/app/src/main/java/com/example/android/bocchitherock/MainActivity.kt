package com.example.android.bocchitherock

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var rockButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rockButton = findViewById(R.id.rock_button)

        val rockAudio = MediaPlayer.create(this, R.raw.bocchi)

        rockButton.setOnClickListener {
            rockAudio.start()
        }

    }
}