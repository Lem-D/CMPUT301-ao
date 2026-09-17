package com.example.decisionmaking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DecisionScreen(
    choices: List<String>,
    question: String,
    modifier: Modifier = Modifier
) {
    var selectedChoice by remember { mutableStateOf<Int?>(null) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(question)
        }
        itemsIndexed(choices) { index, choice ->
            Button(
                onClick = {
                    selectedChoice = index
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(choice)
            }
        }
        if (selectedChoice != null) {
            item {
                if (selectedChoice == 0) {
                    Text("Sure letsgo")

                } else if (selectedChoice == 1) {
                    Text("Not sure")
                } else {
                    Text("No")
                }
            }
        }
    }
}


