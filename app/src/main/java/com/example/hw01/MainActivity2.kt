package com.example.hw01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        intent?.extras?.let{
            val value3 = it.getString("key3")
            val returnedName = findViewById<TextView>(R.id.inputName)
            returnedName?.text = value3.toString()
            val value4 = it.getString("key4")
            val returnedSex = findViewById<TextView>(R.id.inputSex)
            returnedSex?.text = value4.toString()
        }

        val button2 = findViewById<Button>(R.id.send2)
        val inputSize = findViewById<EditText>(R.id.inputSize)
        val inputColor = findViewById<EditText>(R.id.inputColor)
        button2.setOnClickListener{

            val size = inputSize.text.toString()
            val color = inputColor.text.toString()
            val bundle = Bundle()
            bundle.putString("key1",size)
            bundle.putString("key2",color)
            val intent3 = Intent()
            intent3.putExtras(bundle)
            setResult(Activity.RESULT_OK,intent3)
            finish()
        }
    }
}
