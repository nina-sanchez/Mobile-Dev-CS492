package com.example.assignment4


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment4.ui.theme.Assignment4Theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.assignment4.ui.theme.Assignment4Theme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment4Theme {
                MainScreen() // MainScreen will be the entry point
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController = rememberNavController()) {
    val categories = listOf("Beach Clubs", "Restaurants", "Cenotes") // A list of categories

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tulum Recommendations") }
            )
        },
        content = { paddingValues ->
            // LazyColumn is used to display a scrollable list of items
            LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                items(categories) { category ->
                    CategoryItem(category, navController)
                }
            }
        }
    )
}

@Composable
fun CategoryItem(category: String, navController: NavController) {
    // Card to represent each category item
    Card(
        modifier = Modifier.fillMaxSize(),
        onClick = {
            // When a category is clicked, navigate to the recommendation list screen
            navController.navigate("category/$category")
        }
    ) {
        BasicText(text = category) // Display the category name
    }
}




//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Assignment4Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}



//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Assignment4Theme {
//        Greeting("Android")
//    }
//}
