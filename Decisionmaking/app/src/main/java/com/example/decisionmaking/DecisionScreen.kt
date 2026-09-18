package com.example.decisionmaking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun DecisionScreen(
    choices: List<String>,
    question: String,
    modifier: Modifier = Modifier
) {
    var selectedChoice by remember { mutableStateOf<Int?>(null) }
    var decisionResult by remember { mutableStateOf<String?>(null)}

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
            val isSelected = selectedChoice == index
            Button(
                onClick = {
                    selectedChoice = index
                    val roll = Random.nextInt(1,101)
                    val chanceOfYes = when (index) {
                        0 -> 90
                        1 -> 50
                        2 -> 10
                        else -> 0
                    }
                    if (roll <= chanceOfYes){
                        decisionResult = "Yea let's go!"
                    } else {
                        decisionResult = "nah bro"
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    },
                    contentColor = if (isSelected) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            ) {
                Text(choice)
            }
        }
        if(selectedChoice != null && decisionResult != null){
            item{
                Text(decisionResult!!)
                }
            }

    }
}


