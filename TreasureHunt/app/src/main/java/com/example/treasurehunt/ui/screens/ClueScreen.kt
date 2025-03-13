// Regina Sanchez
// OSU
// CS492

package com.example.treasurehunt.ui.screens

import android.annotation.SuppressLint
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.*
import kotlinx.coroutines.delay
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.treasurehunt.data.loadClues
import java.util.Locale


@SuppressLint("MissingPermission")
@Composable
fun ClueScreen(
    onFoundItClicked: () -> Unit,
    onQuitClicked: () -> Unit,
    currentClueIndex: Int,
    updateClueIndex: () -> Unit,
    elapsedTimeMillis: Long,
    updateElapsedTimeMillis: (Long) -> Unit,
    timerPaused: Boolean
) {
    val context = LocalContext.current
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    var location by remember { mutableStateOf<Location?>(null) }
    val clues = remember { loadClues(context) }
    val currentClue = clues.getOrNull(currentClueIndex)
    var showHint by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }


    LaunchedEffect(timerPaused) {
        if (!timerPaused) {
            val startTime = System.currentTimeMillis() - elapsedTimeMillis
            val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000).apply {
                setMinUpdateIntervalMillis(500)
            }.build()

            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    location = locationResult.lastLocation
                    Log.d("CluePage", "Current location: $location")
                }
            }

            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())

            while (true) {
                delay(10L)
                updateElapsedTimeMillis(System.currentTimeMillis() - startTime)
            }
        }
    }

    fun handleFoundIt() {
        if (isLocationCorrect(location, currentClue?.latitude ?: 0.0, currentClue?.longitude ?: 0.0)) {
            Log.d("CluePage", "Location is correct")
            message = "Treasure spot found!!!"
            onFoundItClicked()
        } else {
            Log.d("CluePage", "Location is incorrect")
            message = "Treasure spot wrong... try again..."
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // title section
            currentClue?.let { clue ->

                Text(
                    "Treasure Spot #${currentClueIndex + 1}",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                huntTime(elapsedTimeMillis)
                Spacer(modifier = Modifier.height(16.dp))

                // clue text
                Text("Clue: ${clue.clue}")
                Spacer(modifier = Modifier.height(16.dp))

                // hint Button
                Button(onClick = { showHint = true }) {
                    Text("Hint")
                }
                if (showHint) {
                    Text("Hint: ${clue.hint}")
                    Spacer(modifier = Modifier.height(16.dp))
                }


                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { handleFoundIt() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(
                        "Found It!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 16.dp)
                    )
                }

                // quit Button
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onQuitClicked) {
                    Text("Quit")
                }

                if (message.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(message)
                }
            } ?: run {
                // no more clues
                Text("no more clues....")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onQuitClicked) {
                    Text("Quit")
                }
            }
        }
    }
}


// haversine --> from course given code
fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
    val earthRadius = 6371e3 // meters
    val dLat = Math.toRadians(lat2 - lat1)
    val dLon = Math.toRadians(lon2 - lon1)
    val a = sin(dLat / 2) * sin(dLat / 2) +
            cos(Math.toRadians(lat1)) * cos(Math.toRadians(lat2)) *
            sin(dLon / 2) * sin(dLon / 2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return earthRadius * c
}

// checking user distance with set location
fun isLocationCorrect(location: Location?, targetLat: Double, targetLon: Double): Boolean {
    val thresholdDistance = 25 // meters
    location?.let {
        val distance = haversine(it.latitude, it.longitude, targetLat, targetLon)
        return distance <= thresholdDistance
    }
    return false
}

// timer
@Composable
fun huntTime(elapsedTimeMillis: Long) {
    val minutes = (elapsedTimeMillis / 60000)
    val seconds = (elapsedTimeMillis / 1000) % 60
    val milliseconds = (elapsedTimeMillis % 1000) / 10

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = String.format(Locale.getDefault(), "Total elapsed time: %02d:%02d:%02d", minutes, seconds, milliseconds),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


