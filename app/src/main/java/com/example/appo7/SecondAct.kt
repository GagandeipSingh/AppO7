package com.example.appo7

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondAct : AppCompatActivity() {
    private lateinit var tvName:TextView
    private lateinit var tvNumber:TextView
    private lateinit var tvDoB:TextView
    private lateinit var tvStudy:TextView
    private lateinit var studyL:LinearLayout
    private lateinit var back:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvName = findViewById(R.id.tvName)
        tvNumber = findViewById(R.id.tvNumber)
        tvDoB = findViewById(R.id.tvDoB)
        tvStudy = findViewById(R.id.tvStudy)
        studyL = findViewById(R.id.StudyL)
        back = findViewById(R.id.back)
        intent.extras.let{
            tvName.text = it?.getString("Name")
            tvNumber.text = it?.getString("Number")
            tvDoB.text = (it?.getString("DoB"))
            tvStudy.text = it?.getString("sField")
        }
        if(tvStudy.text == "") studyL.visibility = View.GONE
        back.setOnClickListener {
            finish()
        }
    }
}