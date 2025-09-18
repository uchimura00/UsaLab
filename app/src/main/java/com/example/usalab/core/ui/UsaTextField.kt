package com.example.usalab.core.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.usalab.R
import com.example.usalab.ui.theme.UsaLabTheme

@Composable
fun UsaTextField(
    maxLines: Int,
    testStyle: TextStyle,
    @StringRes placeholder: Int,
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {},
    text: String = "",
    edited : Boolean = false,
) {
    if (!edited) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            textStyle = testStyle,
            modifier = modifier
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(placeholder),
                    style = testStyle,
                    color = Gray
                )
            },
            minLines = 1,
            maxLines = maxLines,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            shape = RoundedCornerShape(16.dp)
        )
    } else {
        Text(
            text = text,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            style = testStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NotepadFieldPreview() {
    UsaLabTheme {
        UsaTextField(
            modifier = Modifier.padding(16.dp),
            maxLines = 3,
            testStyle = MaterialTheme.typography.titleLarge,
            placeholder = R.string.title,
        )
    }
}