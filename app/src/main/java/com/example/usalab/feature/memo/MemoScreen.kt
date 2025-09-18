package com.example.usalab.feature.memo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.usalab.R
import com.example.usalab.core.AppState
import com.example.usalab.core.ui.UsaTextField
import com.example.usalab.ui.theme.UsaLabTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoScreen(
    appState: AppState,
    modifier: Modifier = Modifier,
    viewModel: MemoViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    fun eventHandler(event: MemoUiEvent) {
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "お世話登録") },
                navigationIcon = {
                    IconButton(onClick = { appState.navigateToHome() }) {
                        Icon(
                            painter = painterResource(R.drawable.home),
                            contentDescription = null,
                        )
                    }
                },
            )
        },
        modifier = modifier
    ) { innerPadding ->
        MemoTemplate(
            uiState = uiState,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            eventHandler = {
                eventHandler(it)
            },
        )
    }
}

@Composable
fun MemoTemplate(
    uiState: MemoState,
    eventHandler: (MemoUiEvent) -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    photoUri: String = "https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1170&q=80"
) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        UsaTextField(
            modifier = Modifier.padding(vertical = 8.dp).wrapContentHeight(),
            maxLines = 3,
            testStyle = MaterialTheme.typography.titleLarge,
            placeholder = R.string.title
        )
        UsaTextField(
            modifier = Modifier.padding(vertical = 8.dp).wrapContentHeight(),
            maxLines = 1,
            testStyle = MaterialTheme.typography.labelSmall,
            placeholder = R.string.toDoTime
        )
        val pagerState = rememberPagerState(pageCount = {
            4
        })
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(start = 20.dp, end =40.dp, top = 20.dp, bottom = 20.dp),
            pageSpacing = 6.dp,
            modifier = Modifier.aspectRatio(1f)
        ) { page ->
            Card(
                modifier = Modifier
                    .size(400.dp),
                shape = RoundedCornerShape(24.dp),
                onClick = onClick
            ) {
                AsyncImage(
                    model = photoUri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }
        }
        UsaTextField(
            modifier = Modifier.padding(vertical = 16.dp).fillMaxHeight(),
            maxLines = 5,
            testStyle = MaterialTheme.typography.bodyLarge,
            placeholder = R.string.toDoText,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MemoScreenPreview() {
    UsaLabTheme {
        MemoTemplate(
            uiState = MemoState(),
            eventHandler = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}