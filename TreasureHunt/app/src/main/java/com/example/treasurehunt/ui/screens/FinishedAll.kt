// Regina Sanchez
// OSU
// CS492

package com.example.treasurehunt.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.util.Locale
import com.example.treasurehunt.R


@Composable
fun FinishedHunt(onHomeClicked: () -> Unit, totalElapsedTime: Long) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
            {

            Text(
                text = stringResource(id = R.string.congrats_title),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = stringResource(id = R.string.treasure_hunt_message),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(16.dp))
            val minutes = (totalElapsedTime / 60000)
            val seconds = (totalElapsedTime / 1000) % 60
            val milliseconds = (totalElapsedTime % 1000) / 10
            Text(
                "Total elapsed time: ${String.format(Locale.getDefault(), "%02d:%02d:%02d", minutes, seconds, milliseconds)}",
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onHomeClicked) {
                Text(
                    "Home",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}
