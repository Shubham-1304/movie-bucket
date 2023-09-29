package com.example.test_app.ui.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCornerButton(
) {
    Button(onClick = { },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow.copy(0.8f))
    ) {
        Text("Add +")
    }
}

@Composable
fun AddedTextButton() {
    TextButton(onClick = { }, colors = ButtonDefaults.textButtonColors(contentColor=Color.White)) {
        Text("Added")
    }
}