package com.gabrielpedrosa.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onClose: (WellnessTask) -> Unit,
    modifier: Modifier
) {
    LazyColumn (
        modifier = modifier,
    ) {
        items(
            items = list,
            key = {task -> task.id}
        ) {
            task -> WellnessTaskItem(
                taskName = task.name,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onClose(task) }
            )
        }
    }
}