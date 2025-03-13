// Regina Sanchez
// OSU
// CS492

package com.example.treasurehunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.treasurehunt.data.loadClues
import com.example.treasurehunt.ui.screens.PermissionScreen
import com.example.treasurehunt.ui.screens.StartScreen
import com.example.treasurehunt.ui.screens.ClueScreen
import com.example.treasurehunt.ui.screens.UserSolved
import com.example.treasurehunt.ui.screens.FinishedHunt
import com.example.treasurehunt.ui.theme.TreasureHuntTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureHuntTheme {
                TreasureHuntApp()
            }
        }
    }
}

// running my treasure hunt app, dealing with all screen mobility
@Composable
fun TreasureHuntApp() {
    // setting my variables
    val navController = rememberNavController()
    var permissionGranted by remember { mutableStateOf(false) }
    var currentClueIndex by remember { mutableIntStateOf(0) }
    var elapsedTimeMillis by remember { mutableLongStateOf(0L) }
    var timerPaused by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val clues = remember { loadClues(context) }

    fun timeLapse() {
        elapsedTimeMillis = 0L
        currentClueIndex = 0
        timerPaused = false
    }

    NavHost(navController = navController, startDestination = if (permissionGranted) "start_screen" else "permission_screen") {
        composable("permission_screen") {
            PermissionScreen(
                onPermissionGranted = {
                    permissionGranted = true
                    navController.navigate("start_screen") { popUpTo("permission_screen") { inclusive = true } }
                },
                onPermissionDenied = {  }
            )
        }
        composable("start_screen") {
            StartScreen(navController)
            timeLapse()
        }

        composable("clue_screen") {

            ClueScreen(
                onFoundItClicked = {
                    timerPaused = true
                    navController.navigate("clue_found")
                },
                onQuitClicked = {
                    // if quit, go back to start screen
                    timeLapse()
                    navController.navigate("start_screen") {
                        popUpTo("start_screen") { inclusive = true }
                    }
                },
                currentClueIndex = currentClueIndex,
                updateClueIndex = { currentClueIndex++ },
                elapsedTimeMillis = elapsedTimeMillis,
                updateElapsedTimeMillis = { newTime -> elapsedTimeMillis = newTime },
                timerPaused = timerPaused
            )

        }
        composable("clue_found") { backStackEntry ->
            val clueInfo = clues.getOrNull(currentClueIndex)?.info ?: ""
            UserSolved(
                onContinueClicked = {
                    timerPaused = false
                    if (currentClueIndex < clues.size - 1) {
                        currentClueIndex++
                        navController.navigate("clue_screen")
                    } else {
                        navController.navigate("finished_all")
                    }
                },
                clueInfo = clueInfo,
                totalElapsedTime = elapsedTimeMillis
            )
        }

        composable("finished_all") {
            FinishedHunt(
                onHomeClicked = {
                    timeLapse()
                    navController.navigate("start_screen") {
                        popUpTo("start_screen") { inclusive = true }
                    }
                },
                totalElapsedTime = elapsedTimeMillis
            )
        }
    }
}

