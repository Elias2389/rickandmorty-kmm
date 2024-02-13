package characterlist.presentation.model.state

import characterlist.presentation.model.CharacterUIModel
import characterlist.presentation.model.ErrorTypeUI

data class CharactersState(
    val characters: CharacterUIModel = CharacterUIModel(),
    val error: ErrorTypeUI = ErrorTypeUI.None,
)
