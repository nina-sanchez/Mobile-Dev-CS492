// Regina Sanchez
// OSU
// CS 492

// citing: referenced for my if statement for count
// https://kotlinlang.org/docs/control-flow.html#when-expressions-and-statements
package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE0E0E0))
                {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    // setting my variables
    // count, remembering to stay at value 3 when emulator begins
    var count by remember { mutableIntStateOf(3) }
    // column: image, bio info, buttons (row)
    val image = painterResource(id = R.drawable.disco)

    // column: will hold image, count, bio, + buttons
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top)
    {
        // displaying my disco image
        Image (
            painter = image,
            contentDescription = "disco image",
            modifier = Modifier
                .size(500.dp)
                .padding(top = 30.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        // displaying current count x
        Text (
            text = "Current Count: $count",
            fontWeight = FontWeight.Light,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .background(Color(0xFFB0B0B0))
        )

        // row for my name (bold) + course
        Row (
            modifier = Modifier
                .background(Color(0xFFB0B0B0)))
        {
            // name (bold)
            Text (
                text = "Regina Sanchez ",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .background(Color(0xFFB0B0B0))
            )
            // course (light)
            Text (
                text = "(CS492)",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .background(Color(0xFFB0B0B0))
            )
        }

        Spacer(modifier = Modifier.weight(.2f))

        // buttons, deal with count
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {   // previous button
            Button (
                onClick = {
                    // decrease count --> resets to 5
                    count = if (count > 1) count - 1 else 5
                },
                    modifier = Modifier
                        .weight(1f))
            {
                Text (
                    text = "Previous"
                )
            }

            Spacer(modifier = Modifier.width(32.dp))

            // next button
            Button(
                onClick = {
                    // increment count --> reset to 1 if it goes above 5
                    count = if (count < 5) count + 1 else 1
            },
                    modifier = Modifier
                        .weight(1f))
            {
                Text (
                    text = "  Next  "
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        ArtSpace()
    }
}
