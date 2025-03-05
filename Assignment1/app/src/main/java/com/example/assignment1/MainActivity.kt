// Regina Sanchez
// OSU
// CS 492


package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment1.ui.theme.Assignment1Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color


// main activity --> calling greeting function
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    // column #1: android logo, bio
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xFF7BA57B)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier
                .height(125.dp)
                .width(125.dp)
                .background(Color(0xFF073042))
        )

        Text(text = "Regina Sanchez",
            color = Color.Black,
            fontSize = 35.sp

        )

        Text(text = "CS 492 Student Extraordinaire",
            color = Color(0xFF0C8224),
            fontSize = 15.sp
        )
    }

    // column #2: phone number, instagram, email
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom){

        // phone number
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)){

            val phone = painterResource(id = R.drawable.phone)
            Image(painter = phone,
                contentDescription = null,
                modifier = Modifier.padding(5.dp))

            Text(
                text = "+1 (541) 490-2493",
                color = Color.Black,
                modifier = Modifier.padding(5.dp)
            )
        }

        // instagram
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)){

            val share = painterResource(id = R.drawable.insta)
            Image(painter = share,
                contentDescription = null,
                modifier = Modifier.padding(5.dp))

            Text(
                text = "@Ninaa.Sanchez",
                color = Color.Black,
                modifier = Modifier.padding(5.dp)
            )
        }

        // email
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)){

            val email = painterResource(id = R.drawable.email)
            Image(painter = email,
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp))

            Text(
                text = "sanchreg@oregonstate.com",
                color = Color.Black,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Assignment1Theme {
        Greeting()
    }
}

