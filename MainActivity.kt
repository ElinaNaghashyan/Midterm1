package com.example.myapplication22

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.abs
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BullsEyeGame()
        }
    }
}

@Composable
fun BullsEyeGame() {

    var minRange by remember { mutableStateOf(0) }
    var maxRange by remember { mutableStateOf(100) }
    var sliderValue by remember { mutableStateOf((minRange + maxRange) / 2) }
    var targetValue = Random.nextInt(101)
    var difference = abs(sliderValue - targetValue)

    var score by remember { mutableStateOf(0) }
    var message by remember { mutableStateOf("Your score:$score") }

//    fun checkNumber(number: Float): Any {
//        return when {
//            difference <= 3   -> score += 5
//            difference <= 8 -> score += 1
//            else -> "Try again"
//
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bull's Eye Game", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(60.dp))

        Text("Move the slider as close as you can to: $targetValue", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(50.dp))


        Slider(
            value = sliderValue.toFloat(),
            onValueChange = { newValue -> sliderValue = newValue.toInt() },
            valueRange = minRange.toFloat()..maxRange.toFloat()
        )

        Spacer(modifier = Modifier.height(40.dp))


        @Composable
        fun HitButton(onClick: (Int) -> Unit) {
            Button(
                onClick = {

                    val points = when {
                        difference <= 3 -> 5
                        difference <= 8 -> 1
                        else -> 0
                    }
                    onClick(points)
                }) {
                Text(text = "Hit Me!")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        @Composable
        fun Score(score: Int) {
            Text(text = message,
                fontSize = 20.sp,
                color = Color.Gray
                )
        }

        Text(
            text = message,
            fontSize = 20.sp,
            color = Color.Gray
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BullsEyeGame()
}