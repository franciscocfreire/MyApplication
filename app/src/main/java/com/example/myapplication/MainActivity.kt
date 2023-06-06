package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MYTAG", "OnCreated MainActivity")
        val greetingTextView = findViewById<TextView>(R.id.textView)
        val inputField = findViewById<EditText>(R.id.textName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val offersButton = findViewById<Button>(R.id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener {
            enteredName = inputField.text.toString()
            if (enteredName == "") {
                offersButton.visibility = View.INVISIBLE
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name!!!!",
                    Toast.LENGTH_SHORT
                ).show()


            } else {
                val message = "Welcome $enteredName"
                Log.i("MYTAG", "Message is $message")
                greetingTextView.text = message
                Log.i("MYTAG", "After displaying the message on the TextView")
                inputField.text.clear()
                offersButton.visibility = View.VISIBLE

            }
        }

        offersButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }


    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "App is pause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "App is resume")
    }
}