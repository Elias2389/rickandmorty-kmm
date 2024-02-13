package characterlist.presentation.model

data class CharacterUIModel(
    val info: InfoUIModel = InfoUIModel(),
    val results: List<ResultUIModel> = emptyList()
)
