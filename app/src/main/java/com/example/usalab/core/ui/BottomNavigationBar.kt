package com.example.usalab.core.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShortNavigationBar
import androidx.compose.material3.ShortNavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.usalab.R
import com.example.usalab.core.navigation.HomeRoute
import com.example.usalab.core.navigation.SettingRoute

enum class NavigationItem(
    val route: Any,
    @param: DrawableRes val selectedIcon: Int,
    @param: DrawableRes val unselectedIcon: Int,
    @param: StringRes val label: Int
) {
    HOME(
        route = HomeRoute,
        selectedIcon = R.drawable.home,
        unselectedIcon = R.drawable.home,
        label = R.string.home
    ),
    SETTINGS(
        route = SettingRoute,
        selectedIcon = R.drawable.setting,
        unselectedIcon = R.drawable.setting,
        label = R.string.setting
    )
}

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    onNavigate: (NavigationItem) -> Unit,
    selectedItem: NavigationItem,
    modifier: Modifier = Modifier
) {
    ShortNavigationBar(
        modifier = modifier
    ) {
        items.forEach { item ->
            val isSelected = item == selectedItem
            val icon = if (isSelected) item.selectedIcon else item.unselectedIcon

            ShortNavigationBarItem(
                selected = isSelected,
                onClick = { onNavigate(item) },
                icon = {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = stringResource(id = item.label),
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.label),
                        style = MaterialTheme.typography.labelMedium,
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    var selectedItem by remember { mutableStateOf(NavigationItem.HOME) }

    BottomNavigationBar(
        items = NavigationItem.entries,
        selectedItem = selectedItem,
        onNavigate = { selectedItem = it }
    )
}