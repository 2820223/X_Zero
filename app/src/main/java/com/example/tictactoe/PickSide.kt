package com.example.tictactoe


import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class PickSide: AppCompatActivity(), View.OnClickListener  {
    private lateinit var x_kishi: EditText
    private lateinit var zero_kishi: EditText
    private lateinit var start_game: Button

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pick_your_side)


        x_kishi = findViewById(x_kishi.id)
        zero_kishi = findViewById(zero_kishi.id)
        start_game = findViewById(start_game.id)


        start_game.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        var playerX = x_kishi.text.toString()
        var player0 = zero_kishi.text.toString()
        if (player0.isNullOrEmpty() or playerX.isNullOrEmpty()){
            Toast.makeText(this,"Please enter your names", Toast.LENGTH_LONG).show()
        }
        else{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("player0",player0)
            intent.putExtra("playerX",playerX)
            startActivity(intent)
        }
    }
}