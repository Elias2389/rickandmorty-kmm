package characterlist.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CharacterResponse(
    @SerialName("info")
    val info: InfoResponse,
    @SerialName("results")
    val results: List<ResultResponse>
)
