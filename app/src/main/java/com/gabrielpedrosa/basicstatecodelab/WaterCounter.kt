package com.gabrielpedrosa.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        var count by rememberSaveable { mutableIntStateOf(0) }

        if(count < 0) {
            Text(
                text = pluralStringResource(R.plurals.glass_count, count, count),
            )
        }
        Button( onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 5) {
            Text(text = stringResource(id = R.string.add))
        }
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = pluralStringResource(R.plurals.glass_count, count, count),
        )
        Button( onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 5) {
            Text(text = stringResource(id = R.string.add))
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    StatelessCounter(count, { count++ }, modifier)
}

@Preview
@Composable
fun StatefulCounterPreview(modifier: Modifier = Modifier) {
    StatefulCounter(modifier)
}

@Preview
@Composable
fun WaterCounterPreview(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}
