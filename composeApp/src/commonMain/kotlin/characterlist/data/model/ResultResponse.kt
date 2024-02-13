package characterlist.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultResponse(
    @SerialName("created")
    val created: String = "",
    @SerialName("episode")
    val episode: List<String> = emptyList(),
    @SerialName("gender")
    val gender: String = "",
    @SerialName("id")
    val id: Int = 0,
    @SerialName("image")
    val image: String = "",
    @SerialName("location")
    val location: LocationResponse = LocationResponse(),
    @SerialName("name")
    val name: String = "",
    @SerialName("origin")
    val origin: OriginResponse = OriginResponse(),
    @SerialName("species")
    val species: String = "",
    @SerialName("status")
    val status: String = "",
    @SerialName("type")
    val type: String = "",
    @SerialName("url")
    val url: String = ""
)
