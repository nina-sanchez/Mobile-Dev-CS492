// Regina Sanchez
// OSU
// CS 492

// referenced this on how to create the new files (data, model)
// https://developer.android.com/codelabs/basic-android-kotlin-compose-training-add-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-training-add-scrollable-list#1

package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import com.example.assignment3.ui.theme.Assignment3Theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment3.data.Datasource
import com.example.assignment3.model.Courses

val lightBlue = Color(0xFFA2C9E8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                Surface(modifier = Modifier
                            .fillMaxSize(),
                        color = lightBlue)
                {
                    CourseApp()
                }
            }
        }
    }
}

// getting my data from the data source
@Composable
fun CourseApp() {
    CourseList(courseList = Datasource().getCourses())
}

// looping through to get my data
@Composable
fun CourseList(courseList: List<Courses>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(courseList) { course ->
            CourseCard(course = course,
                        modifier = Modifier
                            .padding(8.dp))
        }
    }
}

// setting how the information will be displayed
@Composable
fun CourseCard(course: Courses,
               modifier: Modifier = Modifier)
    {
    Card(modifier = Modifier
            .padding(top = 12.dp)
            .padding(bottom = 12.dp))
    {
        Column(modifier = Modifier
                .padding(22.dp))
        {
            Text(
                text = "${course.department} ${course.number}",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Text(
                text = stringResource(id = course.title)
            )

            Text(
                text = "Capacity: ${course.capacity}"
            )
        }
    }
}