package com.example.appo7

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var number:EditText
    private lateinit var dob:EditText
    private lateinit var sField:EditText
    private lateinit var checkB:Button
    private lateinit var rdYButton:RadioButton
    private lateinit var rdNButton:RadioButton
    private lateinit var rdGroup:RadioGroup
    private var flag1:Boolean = false
    private var flag2:Boolean = false
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
        number = findViewById(R.id.number)
        dob = findViewById(R.id.db)
        checkB = findViewById(R.id.check)
        rdYButton = findViewById(R.id.yes)
        rdNButton = findViewById(R.id.no)
        rdGroup = findViewById(R.id.radiogroup)
        sField = findViewById(R.id.studying)
        rdGroup.setOnCheckedChangeListener { _, checkedId ->
            rdNButton.error = null
            if(checkedId == rdYButton.id){
                flag1 = true
                flag2 = false
                sField.visibility = View.VISIBLE
            }
            else{
                flag1 = false
                flag2 = true
                sField.visibility = View.GONE
                sField.text = null
            }
        }
            checkB.setOnClickListener {
                if(name.text.toString().trim().isEmpty()){
                    name.error ="Enter Name.."
                }else if(number.text.toString().trim().isEmpty()){
                    number.error="Enter Number.."
                }else if(number.text.toString().trim().length != 10){
                    number.error = "Number should be of 10 digits"
                }
                else if(dob.text.toString().trim().isEmpty()){
                    dob.error="Enter DoB.."
                }else if(flag1 && sField.text.toString().trim().isEmpty()){
                    sField.error = "Enter Study Field.."
                }else if(!flag1 && !flag2){
                    rdNButton.error = "Select the Field.."
                }
                else {
                    Toast.makeText(this, "Correct..", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity,SecondAct::class.java)
                    intent.putExtra("Name",name.text.toString().trim())
                    intent.putExtra("Number",number.text.toString().trim())
                    intent.putExtra("DoB",dob.text.toString().trim())
                    intent.putExtra("sField",sField.text.toString().trim())
                    name.text = null
                    number.text = null
                    dob.text = null
                    sField.text = null
                    rdGroup.clearCheck()
                    name.requestFocus()
                    startActivity(intent)
                }
        }
    }
}