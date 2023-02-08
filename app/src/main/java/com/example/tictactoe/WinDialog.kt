package com.example.tictactoe

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

public class WinDialog(context: Context, message: String, mainActivity: MainActivity) : Dialog(context) {

    private lateinit var messege: String
    private lateinit var mainActivity: MainActivity


    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.win_dialog_layout)
        this.messege = messege
        this.mainActivity = mainActivity



        var messageText = findViewById<TextView>(R.id.messegeText)
        var startAgain_Btn = findViewById<Button>(R.id.startAgain_Btn)

        messageText.setText(messege)

        startAgain_Btn.setOnClickListener {
            @SuppressLint("SetTextI18n", "MissingInflatedId")
            fun onClick(savedInstanceState: Bundle?) {


                mainActivity.restartMatch()
                dismiss()
            }
        }
    }
}


