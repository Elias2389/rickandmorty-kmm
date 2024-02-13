package characterlist.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    @SerialName("count")
    val count: Int = 0,
    @SerialName("next")
    val next: String = "",
    @SerialName("pages")
    val pages: Int = 0,
    @SerialName("prev")
    val prev: String? = null
)
