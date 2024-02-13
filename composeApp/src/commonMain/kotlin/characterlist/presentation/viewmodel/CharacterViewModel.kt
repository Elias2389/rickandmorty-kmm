package characterlist.presentation.viewmodel

import characterlist.domain.usecase.FetchCharacterListUseCase
import characterlist.presentation.mapper.toCharacterUIModel
import characterlist.presentation.model.CharacterUIModel
import common.DefaultRefreshable
import common.Refreshable
import common.State
import common.mapSuccess
import common.refreshStateIn
import kotlinx.coroutines.flow.StateFlow
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class CharacterViewModel(
    private val useCase: FetchCharacterListUseCase,
    refreshable: Refreshable = DefaultRefreshable(),
) : ViewModel(), Refreshable by refreshable {

    val state: StateFlow<State<CharacterUIModel>> =
        useCase()
            .mapSuccess { it.toCharacterUIModel() }
            .refreshStateIn(scope = viewModelScope, refreshWhen = refreshFlow)

}
