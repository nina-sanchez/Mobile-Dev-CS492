// Regina Sanchez
// OSU
// CS 492

package com.example.mycity.ui

import androidx.compose.material.icons.Icons
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.IconButton
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.Alignment
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.MaterialTheme
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.R


enum class HomePage {
    CATEGORY, RECOMMENDATION, DETAIL
}

@Composable
fun NavigationHeader(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    currentScreen: HomePage,
    navigateUp: () -> Unit = {},
    @StringRes headerResId: Int)
    {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 30.dp))
        {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center), // Align the row to the center
            verticalAlignment = Alignment.CenterVertically)
            {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = headerResId),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp),
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel(),
    navController: NavHostController = rememberNavController())
    {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = HomePage.entries.firstOrNull {
        it.name == backStackEntry?.destination?.route
    } ?: HomePage.CATEGORY

    val uiState by viewModel.state.collectAsState()
    MaterialTheme {
        Scaffold(
            topBar = {
                NavigationHeader(
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() },
                    currentScreen = currentScreen,
                    headerResId = if (currentScreen == HomePage.CATEGORY)
                        R.string.app_name
                    else
                        uiState.headerTitleId
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HomePage.CATEGORY.name,
                modifier = Modifier.padding(innerPadding))
                {
                composable(route = HomePage.CATEGORY.name) {
                    CategoryListScreen(
                        categoryList = uiState.categoryList,
                        onCardClick = {
                            viewModel.setCategory(it)
                            navController.navigate(HomePage.RECOMMENDATION.name)
                        }
                    )
                }
                composable(route = HomePage.RECOMMENDATION.name) {
                    RecommendationListScreen(
                        recommendationList = uiState.recommendationList,
                        onCardClick = {
                            viewModel.setRecommendation(it)
                            navController.navigate(HomePage.DETAIL.name)
                        }
                    )
                }
                composable(route = HomePage.DETAIL.name) {
                    DetailsScreen(
                        recommendation = uiState.currentRecommendation
                    )
                }
            }
        }
    }
}
