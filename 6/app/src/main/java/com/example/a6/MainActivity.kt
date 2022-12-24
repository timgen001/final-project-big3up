package com.example.a6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_toast = findViewById<Button>(R.id.btn_toast)
        val btn_custom = findViewById<Button>(R.id.btn_custom)
        val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
        val btn_dialog1 = findViewById<Button>(R.id.btn_dialog1)
        val btn_dialog2 = findViewById<Button>(R.id.btn_dialog2)
        val btn_dialog3 = findViewById<Button>(R.id.btn_dialog3)
        val item = arrayOf("選項 1", "選項 2", "選項 3", "選項 4", "選項 5")
        btn_toast.setOnClickListener {
            showToast("預設 Toast")
        }
        btn_custom.setOnClickListener {
            val toast = Toast(this)
            toast.setGravity(Gravity.TOP, 0, 50)
            toast.duration = Toast.LENGTH_SHORT
            toast.view =
                layoutInflater.inflate(R.layout.custom_toast, null)
            toast.show()
        }
        btn_snackbar.setOnClickListener {
            Snackbar.make(it, "按鈕式 Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("按鈕") {
                    showToast("已回應")
                }.show()
        }
        btn_dialog1.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("按鈕式 AlertDialog")
                .setMessage("AlertDialog 內容")
                .setNeutralButton("左按鈕") { dialog, which ->
                    showToast("左按鈕")
                }
                .setNegativeButton("中按鈕") { dialog, which ->
                    showToast("中按鈕")
                }
                .setPositiveButton("右按鈕") { dialog, which ->
                    showToast("右按鈕")
                }.show()
        }
        btn_dialog2.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("列表式 AlertDialog")
                .setItems(item) { dialogInterface, i ->
                    showToast("你選的是${item[i]}")
                }.show()
        }
        btn_dialog3.setOnClickListener {
            var position = 0
            AlertDialog.Builder(this)
                .setTitle("單選式 AlertDialog")
                .setSingleChoiceItems(item, 0) { dialogInterface, i ->
                    position = i
                }
                .setPositiveButton("確定") { dialog, which ->
                    showToast("你選的是${item[position]}")
                }.show()
        }
    }
    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}