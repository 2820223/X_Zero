package com.example.tictactoe


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


abstract class MainActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var combinationslist: MutableList<MutableList<Int>>
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var img5: ImageView
    private lateinit var img6: ImageView
    private lateinit var img7: ImageView
    private lateinit var img8: ImageView
    private lateinit var img9: ImageView
    private lateinit var boxpositions: MutableList<Any>
    private var playerTurn = 1
    private var totalSelectedBoxes = 1
    private lateinit var x_layout: ConstraintLayout
    private lateinit var zero_layout: ConstraintLayout
    private lateinit var player1_text: TextView
    private lateinit var player2_text: TextView

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        boxpositions = mutableListOf<Any>(0, 0, 0, 0, 0, 0, 0, 0, 0)
        x_layout = findViewById<ConstraintLayout>(R.id.x_layout)
        zero_layout = findViewById(R.id.zero_layout)
        player1_text = findViewById(R.id.player1_text)
        player2_text = findViewById(R.id.player2_text)

        img1 = findViewById<ImageView>(R.id.img1)
        img2 = findViewById<ImageView>(R.id.img2)
        img3 = findViewById<ImageView>(R.id.img3)
        img4 = findViewById<ImageView>(R.id.img4)
        img5 = findViewById<ImageView>(R.id.img5)
        img6 = findViewById<ImageView>(R.id.img6)
        img7 = findViewById<ImageView>(R.id.img7)
        img8 = findViewById<ImageView>(R.id.img8)
        img9 = findViewById<ImageView>(R.id.img9)





        x_layout.setOnClickListener(this)
        zero_layout.setOnClickListener(this)

        combinationslist.add(1, mutableListOf(0, 1, 2))
        combinationslist.add(2, mutableListOf(3, 4, 5))
        combinationslist.add(3, mutableListOf(6, 7, 8))
        combinationslist.add(4, mutableListOf(0, 3, 6))
        combinationslist.add(5, mutableListOf(1, 4, 7))
        combinationslist.add(6, mutableListOf(2, 5, 8))
        combinationslist.add(7, mutableListOf(2, 4, 6))
        combinationslist.add(8, mutableListOf(0, 4, 8))


        val bundle: Bundle? = intent.extras
        var player0 = bundle!!.getString("player0")
        var playerX = bundle!!.getString("playerX")
        Log.d("TAG", "onCreate: " + playerX)
        if (playerX != null) {
            player1_text.text = playerX.toString()
        }
        if (player0 != null) {
            player2_text.text = player0.toString()
        }

       img1.setOnClickListener {
           if (isBoxSelectable(0)){

           }

                 }
        img2.setOnClickListener {
            if (isBoxSelectable(1)){

            }

        }
        img3.setOnClickListener {
            if (isBoxSelectable(2)){

            }

        }
        img4.setOnClickListener {
            if (isBoxSelectable(3)){

            }

        }
        img5.setOnClickListener {
            if (isBoxSelectable(4)){

            }

        }
        img6.setOnClickListener {
            if (isBoxSelectable(5)){

            }

        }
        img7.setOnClickListener {
            if (isBoxSelectable(6)){

            }

        }
        img8.setOnClickListener {
            if (isBoxSelectable(7)){

            }

        }
        img9.setOnClickListener {
            if (isBoxSelectable(8)){

            }

        }
    }


    private fun performAction(imageView: ImageView,selectedBoxPosition : Int) {

        boxpositions[selectedBoxPosition] = playerTurn


        if (playerTurn==1){

            imageView.setImageResource(R.drawable.x)

            if (checkPlayerwin()){


               var winDialog = WinDialog(this,player1_text.text.toString() + " yutdi", this)
                winDialog.setCancelable(false)
                winDialog.show()
            }


            else if (totalSelectedBoxes == 9){

                var winDialog= WinDialog(this, "Teng", this)
                winDialog.setCancelable(false)
                winDialog.show()


            }
            else{
                changeplayerTurn(1)
                totalSelectedBoxes++

            }
        }
        else{
            imageView.setImageResource(R.drawable.zero)


            if ((checkPlayerwin())){



        }

        }






        
    }
private fun changeplayerTurn(currentPlayerTurn:Int) {

    playerTurn=currentPlayerTurn

    if (playerTurn==1){
        x_layout.setBackgroundResource(R.drawable.layout)
    }
    else{
        zero_layout.setBackgroundResource(R.drawable.layout)
    }
    
}



    private fun checkPlayerwin(): Boolean {
        var response = false
        for (i in 0..combinationslist.size){
            var combination= combinationslist.get(i)
            if (boxpositions[combination[0]] == playerTurn && boxpositions[combination[1]] == playerTurn && boxpositions[combination[2]] == playerTurn)
            {
                response = true
            }
        }
        return response
    }
    @SuppressLint("SetTextI18n")
    fun isBoxSelectable(boxposition:Int): Boolean {

var response = false
        if (boxpositions[boxposition] == 0){
            response = true
        }
        return response

    }
    public fun restartMatch() {
        boxpositions = mutableListOf(0,0,0,0,0,0,0,0,0)
        playerTurn =1

        totalSelectedBoxes = 1

        img1.setImageResource(R.drawable.white)
        img2.setImageResource(R.drawable.white)
        img3.setImageResource(R.drawable.white)
        img4.setImageResource(R.drawable.white)
        img5.setImageResource(R.drawable.white)
        img6.setImageResource(R.drawable.white)
        img7.setImageResource(R.drawable.white)
        img8.setImageResource(R.drawable.white)
        img9.setImageResource(R.drawable.white)
        
    }
}