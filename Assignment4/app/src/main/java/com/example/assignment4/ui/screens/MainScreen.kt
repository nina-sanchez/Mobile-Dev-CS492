package com.example.assignment4.ui.screens

import com.example.assignment4.TulumViewModel

import androidx.lifecycle.ViewModel
import com.example.assignment4.data.DataSource
import com.example.assignment4.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost


import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.assignment4.R
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

// Enum to define the app's screens
enum class TulumScreen {
    CATEGORY, RECOMMENDATION, DETAIL
}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TulumAppBar(
//    modifier: Modifier = Modifier,
//    currentScreen: TulumScreen,
//    canNavigateBack: Boolean,
//    navigateUp: () -> Unit = {},
//    @StringRes headerResId: Int
//) {
//    TopAppBar(
//        title = {
//            Text(
//                text = stringResource(id = headerResId),
//                style = MaterialTheme.typography.headlineMedium,
//                color = MaterialTheme.colorScheme.onPrimary,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
//        },
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primary
//        ),
//        modifier = modifier,
//        navigationIcon = {
//            if (canNavigateBack) {
//                IconButton(onClick = navigateUp) {
//                    Icon(
//                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                        contentDescription = stringResource(id = R.string.back_button),
//                        tint = MaterialTheme.colorScheme.onPrimary
//                    )
//                }
//            }
//        }
//    )
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TulumApp(
//    modifier: Modifier = Modifier,
//    viewModel: TulumViewModel = viewModel(),
//    navController: NavHostController = rememberNavController()
//) {
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = TulumScreen.valueOf(
//        backStackEntry?.destination?.route ?: TulumScreen.CATEGORY.name
//    )
//
//    val uiState by viewModel.uiState.collectAsState()
//    MaterialTheme {
//        Scaffold(
//            topBar = {
//                TulumAppBar(
//                    canNavigateBack = navController.previousBackStackEntry != null,
//                    navigateUp = { navController.navigateUp() },
//                    currentScreen = currentScreen,
//                    headerResId = if (currentScreen == TulumScreen.CATEGORY)
//                        R.string.app_name
//                    else
//                        uiState.headerTitleId
//                )
//            }
//        ) { innerPadding ->
//            NavHost(
//                navController = navController,
//                startDestination = TulumScreen.CATEGORY.name,
//                modifier = Modifier.padding(innerPadding)
//            ) {
//                composable(route = TulumScreen.CATEGORY.name) {
//                    CategoryListScreen(
//                        categoryList = uiState.categoryList,
//                        onCardClick = {
//                            viewModel.setCategory(it)
//                            navController.navigate(TulumScreen.RECOMMENDATION.name)
//                        }
//                    )
//                }
//                composable(route = TulumScreen.RECOMMENDATION.name) {
//                    RecommendationListScreen(
//                        recommendationList = uiState.recommendationList,
//                        onCardClick = {
//                            viewModel.setRecommendation(it)
//                            navController.navigate(TulumScreen.DETAIL.name)
//                        }
//                    )
//                }
//                composable(route = TulumScreen.DETAIL.name) {
//                    DetailsScreen(
//                        recommendation = uiState.currentRecommendation
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun CategoryListScreen(
//    categoryList: List<Category>,  // A list of categories to display
//    onCardClick: (Category) -> Unit  // A callback when a category is clicked
//) {
//    LazyColumn {
//        items(categoryList) { category ->
//            Card(
//                modifier = Modifier
//                    .padding(8.dp)
//                    .fillMaxWidth()
//                    .clickable { onCardClick(category) },
//                elevation = 4.dp
//            ) {
//                Text(
//                    text = category.name,
//                    style = MaterialTheme.typography.body1,
//                    modifier = Modifier.padding(16.dp)
//                )
//            }
//        }
//    }
//}
