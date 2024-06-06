package com.example.appo7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var college:EditText
    lateinit var check:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name = findViewById(R.id.name)
        college = findViewById(R.id.college)
        check = findViewById(R.id.check)

            check.setOnClickListener {
                if(name.text.trim().isEmpty()){
                    name.error ="Enter Name.."
                }
                else if(college.text.trim().isEmpty()){
                    college.error="Enter College Name.."
                }
                else {
                    Toast.makeText(this, "Correct..", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this@MainActivity,secondAct::class.java)
                    startActivity(intent)
                }
        }
    }
}