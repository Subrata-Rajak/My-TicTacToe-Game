package com.example.android.tictactoegame

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private lateinit var btn3:Button
    private lateinit var btn4:Button
    private lateinit var btn5:Button
    private lateinit var btn6:Button
    private lateinit var btn7:Button
    private lateinit var btn8:Button
    private lateinit var btn9:Button
    private lateinit var winTxt:TextView
    private lateinit var resetBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        winTxt = findViewById(R.id.winningTxt)
        resetBtn = findViewById(R.id.resetBtn)

        btn1.setOnClickListener{
            whenClicked(btn1)
        }
        btn2.setOnClickListener{
            whenClicked(btn2)
        }
        btn3.setOnClickListener{
            whenClicked(btn3)
        }
        btn4.setOnClickListener{
            whenClicked(btn4)
        }
        btn5.setOnClickListener{
            whenClicked(btn5)
        }
        btn6.setOnClickListener{
            whenClicked(btn6)
        }
        btn7.setOnClickListener{
            whenClicked(btn7)
        }
        btn8.setOnClickListener{
            whenClicked(btn8)
        }
        btn9.setOnClickListener{
            whenClicked(btn9)
        }
        resetBtn.setOnClickListener{
            reset()
        }
    }

    private fun whenClicked(view: android.view.View) {
        val clickedButton = view as Button
        var cellId = 1

        when(clickedButton.id){
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }

        gameLogic(cellId, clickedButton)
    }

    private var activePlayer = 1

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()

    private fun gameLogic(cellId: Int, clickedButton:Button){
        if(activePlayer == 1){
            clickedButton.text = "X"
            clickedButton.setBackgroundColor(Color.BLUE)
            player1.add(cellId)
            activePlayer = 2
        }else if(activePlayer == 2){
            clickedButton.text = "O"
            clickedButton.setBackgroundColor(Color.YELLOW)
            player2.add(cellId)
            activePlayer = 1
        }
        clickedButton.isEnabled = false
        checkWinner()
    }

    private fun checkWinner(){
        var winner = -1

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if(winner == 1){
            winTxt.text = "Player 1 wins the game"
            enableOrNot()
        }else if(winner == 2){
            winTxt.text = "Player 2 wins the game"
            enableOrNot()
        }

        if(!btn1.isEnabled && !btn2.isEnabled && !btn3.isEnabled && !btn4.isEnabled && !btn5.isEnabled && !btn6.isEnabled && !btn7.isEnabled && !btn8.isEnabled && !btn9.isEnabled && winner != 1 && winner != 2){
            winTxt.text = "No One Win!!"
        }
    }

    private fun enableOrNot(){
        if(btn1.isEnabled)
            btn1.isEnabled = false
        if(btn2.isEnabled)
            btn2.isEnabled = false
        if(btn3.isEnabled)
            btn3.isEnabled = false
        if(btn4.isEnabled)
            btn4.isEnabled = false
        if(btn5.isEnabled)
            btn5.isEnabled = false
        if(btn6.isEnabled)
            btn6.isEnabled = false
        if(btn7.isEnabled)
            btn7.isEnabled = false
        if(btn8.isEnabled)
            btn8.isEnabled = false
        if(btn9.isEnabled)
            btn9.isEnabled = false
    }

    private fun reset(){
        btn1.isEnabled = true
        btn1.setBackgroundColor(Color.WHITE)

        btn2.isEnabled = true
        btn2.setBackgroundColor(Color.WHITE)

        btn3.isEnabled = true
        btn3.setBackgroundColor(Color.WHITE)

        btn4.isEnabled = true
        btn4.setBackgroundColor(Color.WHITE)

        btn5.isEnabled = true
        btn5.setBackgroundColor(Color.WHITE)

        btn6.isEnabled = true
        btn6.text = ""
        btn6.setBackgroundColor(Color.WHITE)

        btn7.isEnabled = true
        btn7.setBackgroundColor(Color.WHITE)

        btn8.isEnabled = true
        btn8.setBackgroundColor(Color.WHITE)

        btn9.isEnabled = true
        btn9.setBackgroundColor(Color.WHITE)

        winTxt.text = "Hii Let's play!!"
        player1.clear()
        player2.clear()

        activePlayer = 1;
    }
}