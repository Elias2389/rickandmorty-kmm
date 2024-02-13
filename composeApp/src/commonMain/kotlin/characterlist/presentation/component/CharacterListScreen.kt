package characterlist.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import characterlist.presentation.viewmodel.CharacterViewModel
import characterlist.presentation.model.CharacterUIModel
import common.State
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.koin.koinViewModel

@Composable
fun CharacterListScreen() {
    val viewModel = koinViewModel(CharacterViewModel::class)
    val state by remember(viewModel) { viewModel.state }.collectAsState()

    when(state) {
        is State.Loading -> {

        }
        is State.Failed -> {}
        is State.Loaded -> {
            val result = state as State.Loaded
            LoadCharacterList(characters = result.data)
        }

        else -> {}
    }


}

@Composable
private fun LoadCharacterList(characters: CharacterUIModel) {
    val list = characters.results
    if (list.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items = list) {
                CharacterCard(
                    imageUrl = it.image
                )
            }
        }
    }
}