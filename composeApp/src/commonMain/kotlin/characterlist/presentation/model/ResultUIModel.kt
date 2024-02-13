package characterlist.presentation.model

data class ResultUIModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationUIModel,
    val name: String,
    val origin: OriginUIModel,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
