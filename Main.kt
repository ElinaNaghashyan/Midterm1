package com.example.myapplication22

import BullsEyeGame
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class Main : ComponentMainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BullsEyeGame()
        }
    }
}
