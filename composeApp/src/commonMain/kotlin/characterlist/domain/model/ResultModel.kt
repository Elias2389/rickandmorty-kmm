package characterlist.domain.model

data class ResultModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationModel,
    val name: String,
    val origin: OriginModel,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
