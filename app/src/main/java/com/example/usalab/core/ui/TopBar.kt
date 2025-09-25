package com.example.usalab.core.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.usalab.R
import com.example.usalab.ui.theme.UsaLabTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    @StringRes text: Int,
    @DrawableRes icon: Int,
    actions: @Composable RowScope.() -> Unit = {},
    onClick: () -> Unit = { },
    enabled: Boolean = true,

    ) {
    TopAppBar(
        title = { Text(text = stringResource(text)) },
        navigationIcon = {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(12.dp)
                    .clickable(
                        onClick = onClick,
                        enabled = enabled
                    )
            )
        },
        actions = actions
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    UsaLabTheme {
        TopBar(
            text = R.string.app_name,
            icon = R.drawable.home,
        )
    }
}