package com.example.submition

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import java.text.NumberFormat
import java.util.Locale


class NextPage : AppCompatActivity() {
    lateinit var text1: TextView
    lateinit var text2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_page)
        val button2 = findViewById<Button>(R.id.button3)
        button2.setOnClickListener() {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }
        val button3 = findViewById<Button>(R.id.button4)
        val num1 = findViewById<EditText>(R.id.num)
        val spinnercur = findViewById<Spinner>(R.id.simplespinner)
        val text1 = findViewById<TextView>(R.id.result)
        button3.setOnClickListener() {
            val amount = num1.text.toString()
            if (amount.isNotEmpty()) {
                val amount1 = amount.toDouble()
                val selected = spinnercur.selectedItem.toString()
                val convert= converttoIndian(amount1,selected)
                text1.text = convert
            } else {
                Toast.makeText(this, "Please enter an amount", Toast.LENGTH_LONG)
            }
        }
        val button4=findViewById<ImageButton>(R.id.button5)
        button4.setOnClickListener(){
            num1.setText("")
            text1.setText("")
        }
    }
    private fun converttoIndian(amount1:Double,currency:String): String {
        val exchanges= mapOf(
            "Dollar" to 83.59,
            "Pound" to 105.34,
            "Yen" to 0.55,
            "Dhiram" to 22.76,
            "Euro" to 90.8,
            "Mexican Peso" to 4.99,
            "Rubble" to 0.91,
        )
        val rupp=amount1*exchanges[currency]!!
        val formatter:NumberFormat=NumberFormat.getCurrencyInstance(Locale("en","IN"))
        return formatter.format(rupp)
    }
}




