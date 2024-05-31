package com.example.captaingame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.captaingame.ui.theme.CaptaingameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptaingameTheme {
                CaptainGame()
            }
        }
    }
}

@Composable
fun CaptainGame() {
    val treasureFound = remember { mutableStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val sailCount = remember { mutableStateOf(0) }
    val StormOrTreasure=remember { mutableStateOf("") }
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Treasure Found: ${treasureFound.value}",
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Current Direction: ${direction.value}",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${StormOrTreasure.value}",
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        direction.value = "East"
                        if (Random.nextBoolean()) {
                            treasureFound.value += 1
                            StormOrTreasure.value="WE FOUND A TREASURE!!!"
                        }else{
                            StormOrTreasure.value="OOPS THERE'S A Storm Ahead!!!!"
                        }
                        sailCount.value += 1
                    }
                ) {
                    Text(text = "Sail East")
                }
                Button(
                    onClick = {
                        direction.value = "West"
                        if (Random.nextBoolean()) {
                            treasureFound.value += 1
                            StormOrTreasure.value="WE FOUND A TREASURE!!!"
                        }else{
                            StormOrTreasure.value="OOPS THERE'S A Storm Ahead!!!!"
                        }
                        sailCount.value += 1
                    }
                ) {
                    Text(text = "Sail West")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        direction.value = "North"
                        if (Random.nextBoolean()) {
                            treasureFound.value += 1
                            StormOrTreasure.value="WE FOUND A TREASURE!!!"
                        }else{
                            StormOrTreasure.value="OOPS THERE'S A Storm Ahead!!!!"
                        }
                        sailCount.value += 1
                    }
                ) {
                    Text(text = "Sail North")
                }
                Button(
                    onClick = {
                        direction.value = "South"
                        if (Random.nextBoolean()) {
                            treasureFound.value += 1
                            StormOrTreasure.value="WE FOUND A TREASURE!!!"
                        }else{
                            StormOrTreasure.value="OOPS THERE'S A Storm Ahead!!!!"
                        }
                        sailCount.value += 1
                    }
                ) {
                    Text(text = "Sail South")
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    val treasureFoundValue = treasureFound.value
                    treasureFound.value = 0
                    direction.value = "North"
                    Toast.makeText(
                        context,
                        "Treasure Found: $treasureFoundValue, Times Sailed: ${sailCount.value}",
                        Toast.LENGTH_SHORT
                    ).show()
                    sailCount.value = 0
                }
            ) {
                Text(text = "Finish")
            }
        }
    }
}