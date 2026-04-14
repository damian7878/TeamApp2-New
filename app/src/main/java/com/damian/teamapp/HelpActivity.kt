/*
HelpActivity.kt

Purpose:
This activity provides instructions to the user on how to use the application.

Functionality:
- Displays a help message explaining how the buttons work.
- Opened from MainActivity using an Intent.

Key Concepts:
- Multiple activity navigation
- Simple UI display using a TextView
*/

package com.damian.teamapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }
}