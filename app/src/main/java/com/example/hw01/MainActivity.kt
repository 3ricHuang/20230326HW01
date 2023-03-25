package com.example.hw01

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputName = findViewById<EditText>(R.id.inputName)
        val inputSex = findViewById<EditText>(R.id.inputSex)

        val button1 = findViewById<Button>(R.id.send1)
        button1.setOnClickListener{
            val name = inputName.text.toString()
            val sex = inputSex.text.toString()
            val bundle = Bundle()
            bundle.putString("key3",name)
            bundle.putString("key4",sex)
            val intent2 = Intent(this,MainActivity2::class.java)
            intent2.putExtras(bundle)
            startActivityForResult(intent2,1)
        }

    }
    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let{ it ->
            if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
                val extras = data.extras
                if (extras != null) {
                    val name = extras.getString("key3")
                    val sex = extras.getString("key4")
                    if (name != null && sex != null) {
                        findViewById<TextView>(R.id.inputName).text = "Name:${name}\n\n"
                        findViewById<TextView>(R.id.inputSex).text = "Sex:${sex}\n\n"
                    }
                }
            }

            if (requestCode == 1 && resultCode == Activity.RESULT_OK)
            {
                val value1 = it.getString("key1")
                val value2 = it.getString("key2")
                val returnedSize = findViewById<TextView>(R.id.returnedSize)
                val returnedColor = findViewById<TextView>(R.id.returnedColor)
                returnedSize.text = "Size: ${value1.toString()}\n\n"
                returnedColor.text ="Color: ${value2.toString()}\n\n"
            }
        }
    }
}
