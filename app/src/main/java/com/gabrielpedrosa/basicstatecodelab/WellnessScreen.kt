package com.gabrielpedrosa.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier, wellnessTaskViewModel: WellnessTaskViewModel = viewModel()) {
    Column {
        StatefulCounter(modifier)

        WellnessTasksList(
            list = wellnessTaskViewModel.tasks,
            onCheckedTask = {task, checked -> wellnessTaskViewModel.changeTaskChecked(task, checked) },
            onClose = {wellnessTask -> wellnessTaskViewModel.remove(wellnessTask) },
            modifier = modifier
        )
    }
}


@Preview
@Composable
fun WellnessScreenPreview(modifier: Modifier = Modifier) {
    WellnessScreen(modifier)
}
