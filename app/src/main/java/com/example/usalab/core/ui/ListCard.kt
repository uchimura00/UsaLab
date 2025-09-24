package com.example.usalab.core.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.usalab.ui.theme.UsaLabTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ListCard(
    toDoDate: String,
    toDoName: String,
    genre: String,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier,
    deleteEnabled: Boolean = false,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    Card(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .clickable(onClick = onCardClick),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.padding(start = 16.dp))
            val density = LocalDensity.current
            AnimatedVisibility(
                visible = deleteEnabled,
                enter = slideInHorizontally(
                    animationSpec = MaterialTheme.motionScheme.slowSpatialSpec()
                ) {
                    with(density) { -40.dp.roundToPx() }
                } + expandHorizontally(
                    expandFrom = Alignment.Start,
                    animationSpec = MaterialTheme.motionScheme.slowSpatialSpec()
                ),
                exit = slideOutHorizontally(
                    animationSpec = MaterialTheme.motionScheme.slowSpatialSpec()
                ) + shrinkHorizontally(
                    animationSpec = MaterialTheme.motionScheme.slowSpatialSpec()
                )
            ) {
                Checkbox(
                    onCheckedChange = onCheckedChange,
                    checked = checked,
                    modifier = Modifier
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 6.dp, end = 12.dp, bottom = 6.dp)
            ) {
                Text(
                    text = genre,
                    style = typography.labelSmall
                )
                Text(
                    text = toDoName,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = typography.titleLarge,
                )
                Text(
                    text = toDoDate,
                    style = typography.titleLarge
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArticleCardPreview() {
    UsaLabTheme {
        ListCard(
            toDoDate = "9:00",
            toDoName = "草を食べる",
            genre = "牧草",
            onCardClick = {},
        )
    }
}