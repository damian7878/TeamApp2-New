/*
MainActivity.kt

Purpose:
This is the main screen of the application. It allows the user to increase or reset a score using buttons.

Functionality:
- Displays the current score on screen.
- "Add 1" button increases the score by 1.
- "Add 3" button increases the score by 3.
- "Reset" button sets the score back to 0.
- "Help" button opens a second screen (HelpActivity).
- Saves and restores the score when the device rotates using onSaveInstanceState.

Key Concepts:
- Activity lifecycle (onCreate, onSaveInstanceState)
- UI interaction using buttons and click listeners
- Navigation using Intent
- Data persistence during configuration changes
*/

package com.damian.teamapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var score = 0
    private lateinit var scoreText: TextView

    companion object {
        private const val SCORE_KEY = "score_key"
        private const val WIN_SCORE = 15
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("ScoreApp", "APP STARTED")

        scoreText = findViewById(R.id.scoreText)
        val addOneButton: Button = findViewById(R.id.btnAddOne)
        val addThreeButton: Button = findViewById(R.id.btnAddThree)
        val resetButton: Button = findViewById(R.id.btnReset)
        val helpButton: Button = findViewById(R.id.btnHelp)

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt(SCORE_KEY, 0)
        }

        updateScore()

        addOneButton.setOnClickListener {
            Log.d("ScoreApp", "Add 1 clicked")
            score += 1
            updateScore()
            checkWin()
        }

        addThreeButton.setOnClickListener {
            Log.d("ScoreApp", "Add 2 clicked")
            score += 3
            updateScore()
            checkWin()
        }

        resetButton.setOnClickListener {
            Log.d("ScoreApp", "Reset clicked")
            score = 0
            updateScore()
        }

        helpButton.setOnClickListener {
            Log.d("ScoreApp", "Help clicked")
            startActivity(Intent(this, HelpActivity::class.java))
        }

    }

    private fun updateScore() {
        scoreText.text = getString(R.string.score_value, score)
    }

    private fun checkWin() {
        if (score >= WIN_SCORE) {
            // You can add a toast or sound later
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("ScoreApp", "State saved: $score")
        super.onSaveInstanceState(outState)
        outState.putInt(SCORE_KEY, score)
    }
}