package com.example.a10

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img_frame = findViewById<ImageView>(R.id.img_frame)
        val img_tween = findViewById<ImageView>(R.id.img_tween)
        val btn_start = findViewById<Button>(R.id.btn_start)
        val btn_stop = findViewById<Button>(R.id.btn_stop)
        val btn_alpha = findViewById<Button>(R.id.btn_alpha)
        val btn_scale = findViewById<Button>(R.id.btn_scale)
        val btn_translate = findViewById<Button>(R.id.btn_translate)
        val btn_rotate = findViewById<Button>(R.id.btn_rotate)
        img_frame.setBackgroundResource(R.drawable.loading_animation)
        btn_start.setOnClickListener {
            val animation = img_frame.background as AnimationDrawable
            animation.start()
        }
        btn_stop.setOnClickListener {
            val animation = img_frame.background as AnimationDrawable
            animation.stop()
        }
        btn_alpha.setOnClickListener {
            val anim = AlphaAnimation(
                1.0f,
                0.2f
            )
            anim.duration = 1000
            img_tween.startAnimation(anim)
        }
        btn_scale.setOnClickListener {
            val anim = ScaleAnimation(
                1.0f,
                1.5f,
                1.0f,
                1.5f
            )
            anim.duration = 1000
            img_tween.startAnimation(anim)
        }
        btn_translate.setOnClickListener {
            val anim = TranslateAnimation(
                0f,
                100f,
                0f,
                -100f
            )
            anim.duration = 1000
            img_tween.startAnimation(anim)
        }
        btn_rotate.setOnClickListener {
            val anim = RotateAnimation(
                0f,
                360f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f
            )
            anim.duration = 1000
            img_tween.startAnimation(anim)
        }
    }
}