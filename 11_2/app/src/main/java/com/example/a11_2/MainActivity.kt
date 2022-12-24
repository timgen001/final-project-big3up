package com.example.a11_2

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var angle = 0f
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == RESULT_OK) {
            val image = data?.extras?.get("data") ?: return
            findViewById<ImageView>(R.id.imageView).setImageBitmap(image as Bitmap)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_photo).setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(intent, 0)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "此裝置無相機應用程式", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn_rotate).setOnClickListener {
            angle += 90f
            findViewById<ImageView>(R.id.imageView).rotation = angle
        }
    }
}