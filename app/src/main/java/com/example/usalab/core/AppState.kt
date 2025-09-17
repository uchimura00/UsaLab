package com.example.usalab.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.usalab.core.navigation.HomeRoute
import com.example.usalab.core.ui.NavigationItem
import com.example.usalab.core.utill.AppStateModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(
        navController,
    ) {
        AppState(
            navController = navController,
        )
    }
}

@Stable
class AppState(
    val navController: NavHostController,
) {
    private val previousDestination = mutableStateOf<NavDestination?>(null)

    private val _appStateModel = MutableStateFlow(AppStateModel())
    val appStateModel: StateFlow<AppStateModel> = _appStateModel.asStateFlow()

    val currentDestination: NavDestination?
        @Composable get() {
            val currentEntry = navController.currentBackStackEntryFlow
                .collectAsState(initial = null)

            return currentEntry.value?.destination.also { destination ->
                if (destination != null) {
                    previousDestination.value = destination
                }
            } ?: previousDestination.value
        }

    val selectedNavigationItem: NavigationItem
        @Composable
        get() {
            val currentRoute = currentDestination?.route
            return NavigationItem.entries.find { item ->
                currentRoute == item.route::class.qualifiedName
            } ?: NavigationItem.HOME
        }

    fun navigateToHome() {
        navController.navigate(HomeRoute)
    }

    fun navigatePopUp() {
        navController.popBackStack()
    }

    fun bottomBarNavigateTo(item: NavigationItem) {
        navController.navigate(item.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}